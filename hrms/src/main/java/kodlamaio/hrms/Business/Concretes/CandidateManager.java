package kodlamaio.hrms.Business.Concretes;

import kodlamaio.hrms.Business.Abstracts.CandidateService;
import kodlamaio.hrms.Business.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.hrms.Business.Responses.CandidateResponses.GetAllCandidateResponse;
import kodlamaio.hrms.Business.Verifications.EmailVerification;
import kodlamaio.hrms.Business.Verifications.MernisVerification;
import kodlamaio.hrms.DataAccess.Abstracts.CandidateRepository;
import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateRepository candidateRepository;


    @Autowired
    public CandidateManager(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;

    }


    @Override
    public Result add(AddCandidateRequest addCandidateRequest) {

        EmailVerification emailVerification = new EmailVerification();
        MernisVerification mernisVerification = new MernisVerification();

        //addRequest nesnesini candidate nesnesine atama yapıyoruz:
        Candidate candidate = Candidate.builder().
                name(addCandidateRequest.getName()).
                surname(addCandidateRequest.getSurname()).
                nationalID(addCandidateRequest.getNationalID()).
                yearOfBirth(addCandidateRequest.getYearOfBirth()).
                emailAddress(addCandidateRequest.getEmailAddress()).
                password(addCandidateRequest.getPassword()).
                build();


        if (!candidate.getPassword().equals(addCandidateRequest.getRepeatPassword())) {

            throw new IllegalArgumentException("Passwords is not matching !");
        }

        if (this.candidateRepository.existsByEmailAddress(candidate.getEmailAddress())) {

            throw new IllegalArgumentException("Email address already in DB !");
        }

        mernisVerification.verify(candidate.getName(), candidate.getSurname(), candidate.getNationalID(), candidate.getYearOfBirth());
        emailVerification.sentEmail(candidate.getEmailAddress());

        this.candidateRepository.save(candidate);


        return new SuccessResult("Candidate added to Database: " + candidate.getName());
    }

    @Override
    public DataResult<List<GetAllCandidateResponse>> getAll() {

        List<GetAllCandidateResponse> responseList = new ArrayList<GetAllCandidateResponse>();


        for (Candidate candidate : candidateRepository.findAll()) {


            responseList.add(new GetAllCandidateResponse(candidate));
        }


        return new SuccessDataResult<List<GetAllCandidateResponse>>(responseList, "Bütün Data Listelendi");
    }

    @Override
    public DataResult<GetAllCandidateResponse> getById(int id) {


        return new SuccessDataResult<GetAllCandidateResponse>(
                new GetAllCandidateResponse(this.candidateRepository.findById(id).get()), "ID üzerinden getirildi");
    }
}
