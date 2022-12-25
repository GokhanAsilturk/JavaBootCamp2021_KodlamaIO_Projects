package kodlamaio.hrms.Business.Concretes;

import kodlamaio.hrms.Business.Abstracts.EmployerService;
import kodlamaio.hrms.Business.Requests.EmployerRequests.AddEmployerRequest;
import kodlamaio.hrms.Business.Responses.EmployerResponses.GetAllEmployerResponse;
import kodlamaio.hrms.Business.Verifications.EmailVerification;
import kodlamaio.hrms.Business.Verifications.HrmsEmployeeVerification;
import kodlamaio.hrms.DataAccess.Abstracts.EmployerRepository;
import kodlamaio.hrms.Entities.Concretes.Employer;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    EmployerRepository employerRepository;

    @Autowired
    public EmployerManager(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Result add(AddEmployerRequest addEmployerRequest) {

        EmailVerification emailVerification = new EmailVerification();
        HrmsEmployeeVerification hrmsEmployeeVerification = new HrmsEmployeeVerification();

        //Builder ile atamalarımızı yapıyoruz.
        Employer employer = Employer.builder().
                companyName(addEmployerRequest.getCompanyName()).
                emailAddress(addEmployerRequest.getEmailAddress()).
                website(addEmployerRequest.getWebsite()).
                phoneNumber(addEmployerRequest.getPhoneNumber()).
                password(addEmployerRequest.getPassword()).
                build();


        if (!addEmployerRequest.getRepeatPassword().equals(employer.getPassword())) {
            throw new IllegalArgumentException("Passwords is not matching !");
        }

        if (this.employerRepository.existsByEmailAddress(employer.getEmailAddress())) {

            throw new IllegalArgumentException("Email address already in DB !");
        }

        emailVerification.sentEmail(employer.getEmailAddress());
        hrmsEmployeeVerification.verifyEmployer(employer);

        this.employerRepository.save(employer);
        return new SuccessResult("Employer added to DB: " + employer.getCompanyName());
    }

    @Override
    public DataResult<List<GetAllEmployerResponse>> getAll() {

        List<GetAllEmployerResponse> responseList = new ArrayList<GetAllEmployerResponse>();


        for (Employer employer : this.employerRepository.findAll()) {

            responseList.add(new GetAllEmployerResponse(employer));

        }
        return new SuccessDataResult<List<GetAllEmployerResponse>>(responseList, "Data Listelendi");
    }

    @Override
    public DataResult<GetAllEmployerResponse> getById(int id) {


        return new SuccessDataResult<GetAllEmployerResponse>(
                new GetAllEmployerResponse(this.employerRepository.findById(id).get()),"ID üzerinden getirildi");
    }
}
