package kodlamaio.basicLinkedInProject.Business.Concretes;

import kodlamaio.basicLinkedInProject.Business.Abstracts.CandidateService;
import kodlamaio.basicLinkedInProject.DTO.Mappers.CandidateMapper;
import kodlamaio.basicLinkedInProject.DTO.Mappers.EmployerMapper;
import kodlamaio.basicLinkedInProject.DTO.Mappers.JobAdvertMapper;
import kodlamaio.basicLinkedInProject.DTO.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllEmployersResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllJobAdvertsResponse;
import kodlamaio.basicLinkedInProject.DataAccess.CandidateRepository;
import kodlamaio.basicLinkedInProject.DataAccess.EmployerRepository;
import kodlamaio.basicLinkedInProject.DataAccess.JobAdvertRepository;
import kodlamaio.basicLinkedInProject.Entities.JobAdvert;
import kodlamaio.basicLinkedInProject.core.Results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;
    private final EmployerRepository employerRepository;
    private final JobAdvertRepository jobAdvertRepository;

    private final JobAdvertMapper jobAdvertMapper;
    private final EmployerMapper employerMapper;


    @Autowired
    public CandidateManager(CandidateRepository candidateRepository, CandidateMapper candidateMapper,
                            EmployerRepository employerRepository, JobAdvertRepository jobAdvertRepository,
                            JobAdvertMapper jobAdvertMapper, EmployerMapper employerMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
        this.employerRepository = employerRepository;
        this.jobAdvertRepository = jobAdvertRepository;
        this.jobAdvertMapper = jobAdvertMapper;
        this.employerMapper = employerMapper;

    }


    @Override
    public Result add(AddCandidateRequest addCandidateRequest) {

        if (this.candidateRepository.existsByEmailAdress(addCandidateRequest.emailAddress())) {
            return new ErrorResult("This email adress already used! : " + addCandidateRequest.emailAddress());
        }

        this.candidateRepository.save(this.candidateMapper.addCandidateRequestToCandidate(addCandidateRequest));

        return new SuccessResult("Candidate added to database: " + addCandidateRequest.name() + " " + addCandidateRequest.surname());
    }

    @Override
    public DataResult<List<GetAllEmployersResponse>> getAllEmployers() {

        return new SuccessDataResult<>(this.employerRepository.findAll().
                stream().map(this.employerMapper::employerToGetAllEmployersResponse).collect(Collectors.toList()));


        //candidate mapper ın liste şeklinde çalışabilmesi için yukarıdaki kodun daha anlaşılabilir örneği;

//        List<Employer> employerList = employerRepository.findAll();
//        List<GetAllEmployersResponse> getAllEmployersResponses = new ArrayList<>();
//
//        for (Employer e : employerList) {
//
//            getAllEmployersResponses.add(candidateMapper.employerToGetAllEmployersResponse(e));
//        }
//        return new SuccessDataResult<>(getAllEmployersResponses);
    }

    @Override

    public DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdverts() {

        //request ile gelen değerleri istediğimiz değerlere(Response için) dönüştürürken mapperImpl içerisinde değiştirdik.
        return new SuccessDataResult<>(this.jobAdvertRepository.getByAdvertSituationTrue().stream().
                map(this.jobAdvertMapper::jobAdvertToGetAllJobAdvertsResponse).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsByEmployer(int employerId) {

        //request ile gelen değerleri istediğimiz değerlere(Response için) dönüştürürken mapperImpl içerisinde değiştirdik.
        List<JobAdvert> jobAdvertsByEmployerList = this.employerRepository.findById(employerId).get().getJobAdverts();

        return new SuccessDataResult<>(jobAdvertsByEmployerList.stream().
                map(this.jobAdvertMapper::jobAdvertToGetAllJobAdvertsResponse).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsSortedByDeadline() {

        List<JobAdvert> jobAdverts = this.jobAdvertRepository.findAll();

        //Tarihlere göre sırala.
        //Sıralama işlemini Collections.sort() metodunu kullanarak gerçekleştirebiliriz.
        /* Comparator arayüzü kullanarak compare() metodu tanımlıyoruz. Bu metodda, iki jobAdvert nesnesi alıyoruz ve
         bu nesnelerin 'deadline' özelliklerini karşılaştırıyoruz.
         compareTo() metodu, iki tarih arasındaki karşılaştırmayı gerçekleştiriyor ve sonucu bize döndürüyor.*/
        Collections.sort(jobAdverts, new Comparator<JobAdvert>() {
            public int compare(JobAdvert a, JobAdvert b) {

                return a.getDeadline().compareTo(b.getDeadline());
            }
        });

        return new SuccessDataResult<>(jobAdverts.stream().
                map(this.jobAdvertMapper::jobAdvertToGetAllJobAdvertsResponse).collect(Collectors.toList()));
    }
}
