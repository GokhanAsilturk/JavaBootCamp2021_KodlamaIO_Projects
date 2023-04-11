package kodlamaio.basicLinkedInProject.Business.Concretes;

import kodlamaio.basicLinkedInProject.Business.Abstracts.EmployerService;
import kodlamaio.basicLinkedInProject.DTO.Mappers.CityMapper;
import kodlamaio.basicLinkedInProject.DTO.Mappers.EmployerMapper;
import kodlamaio.basicLinkedInProject.DTO.Mappers.JobAdvertMapper;
import kodlamaio.basicLinkedInProject.DTO.Mappers.PositionMapper;
import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.*;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllCitiesResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllPositionsResponse;
import kodlamaio.basicLinkedInProject.DataAccess.CityRepository;
import kodlamaio.basicLinkedInProject.DataAccess.EmployerRepository;
import kodlamaio.basicLinkedInProject.DataAccess.JobAdvertRepository;
import kodlamaio.basicLinkedInProject.DataAccess.PositionRepository;
import kodlamaio.basicLinkedInProject.Entities.JobAdvert;
import kodlamaio.basicLinkedInProject.core.Results.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerRepository employerRepository;
    private final JobAdvertRepository jobAdvertRepository;
    private final PositionRepository positionRepository;
    private final CityRepository cityRepository;

    private final EmployerMapper employerMapper;
    private final JobAdvertMapper jobAdvertMapper;
    private final PositionMapper positionMapper;
    private final CityMapper cityMapper;

    @Autowired
    public EmployerManager(EmployerRepository employerRepository, JobAdvertRepository jobAdvertRepository, PositionRepository positionRepository, CityRepository cityRepository, EmployerMapper employerMapper, JobAdvertMapper jobAdvertMapper, PositionMapper positionMapper, CityMapper cityMapper) {
        this.employerRepository = employerRepository;
        this.jobAdvertRepository = jobAdvertRepository;
        this.positionRepository = positionRepository;
        this.cityRepository = cityRepository;
        this.employerMapper = employerMapper;
        this.jobAdvertMapper = jobAdvertMapper;
        this.positionMapper = positionMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public Result add(AddEmployerRequest addEmployerRequest) {

        if (this.employerRepository.existsByCompanyName(addEmployerRequest.companyName())) {
            return new ErrorResult("This company name is already used!: " + addEmployerRequest.companyName());
        } else if (this.employerRepository.existsByEmailAddress(addEmployerRequest.emailAddress())) {
            return new ErrorResult(("This email adress is already used!: " + addEmployerRequest.emailAddress()));
        }

        this.employerRepository.save(this.employerMapper.addEmployerRequestToEmployer(addEmployerRequest));

        return new SuccessResult("Employer added to database: " + addEmployerRequest.companyName());
    }

    @Override
    public Result addJobAdvert(AddJobAdvertRequest addJobAdvertRequest) {

        JobAdvert jobAdvert = this.jobAdvertMapper.addJobAdvertRequestToJobAdvert(addJobAdvertRequest);

        //Bu işlemi mapper içerisinde yapabilirdik fakat daha rahat görünmesi için buraya yazdık.
        //Kullanıcının string olarak girdiği tarihler, DateTimeFormatter sınıfı ile LocalDate nesnelerine dönüştürülür
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //addjobAdvert ile gelen string tarihi lacalDate formatına çevirip entity mize kaydediyoruz.
        LocalDate deadline = LocalDate.parse(addJobAdvertRequest.deadline(), formatter);
        //Deadline ı değişkenimize atıyoruz.
        jobAdvert.setDeadline(deadline);

        //Bütün değişken atamaları bitince jobAdvert nesnemizi entity olarak kaydediyoruz.
        this.jobAdvertRepository.save(jobAdvert);

        return new SuccessResult("Job Advert added to database: " + addJobAdvertRequest.title());
    }

    @Override
/*   bu metot @Transactional anotasyonu ile işlem (transaction) içinde çalıştırılmaktadır.
     Bu sayede, MyEntity nesnesinin advertSituation alanı "false" olarak güncellendiğinde,
     işlem (transaction) otomatik olarak başlatılır ve sonlandırılır. Böylece,
     "javax.persistence.TransactionRequiredException: Executing an update/delete query" hatası önlenmiş olur.*/
    @Transactional
    public Result deActivateJobAdvert(@NotNull DeActivateJobAdvertRequest deActivateJobAdvertRequest) {

        this.jobAdvertRepository.updateAdvertSituationToFalse(deActivateJobAdvertRequest.jobId());

        return new SuccessResult("Job Advert is deactivated! : " + this.jobAdvertRepository.
                findById(deActivateJobAdvertRequest.jobId()).get().getTitle());
    }

    @Override
    public Result activateJobAdvert(ActivateJobAdvertRequest activateJobAdvertRequest) {

        this.jobAdvertRepository.updateAdvertSituationToTrue(activateJobAdvertRequest.jobId());

        return new SuccessResult("Job Advert is activated! : " + this.jobAdvertRepository.
                findById(activateJobAdvertRequest.jobId()).get().getTitle());
    }

    @Override
    public Result addPosition(AddPositionRequest addPositionRequest) {

        this.positionRepository.save(this.positionMapper.addPositionRequestToPosition(addPositionRequest));

        return new SuccessResult("Position added : " + addPositionRequest.positionName());
    }

    @Override
    public Result addCity(AddCityRequest addCityRequest) {

        this.cityRepository.save(this.cityMapper.addCityRequestToCity(addCityRequest));

        return new SuccessResult("City added : " + addCityRequest.cityName());
    }

    @Override
    public DataResult<List<GetAllCitiesResponse>> getAllCities() {

        return new SuccessDataResult<>(this.cityRepository.findAll().
                stream().map(this.cityMapper::cityToAllCitiesResponse).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<GetAllPositionsResponse>> getAllPositions() {
        return new SuccessDataResult<>(this.positionRepository.findAll().
                stream().map(this.positionMapper::positionGetAllPositionsResponse).collect(Collectors.toList()));
    }
}
