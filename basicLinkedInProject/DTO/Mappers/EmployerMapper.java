package kodlamaio.basicLinkedInProject.DTO.Mappers;

import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.AddEmployerRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllEmployersResponse;
import kodlamaio.basicLinkedInProject.Entities.Employer;
import org.mapstruct.Mapper;

@Mapper(implementationName = "EmployerMapperImpl", componentModel = "spring")
public interface EmployerMapper {

    Employer addEmployerRequestToEmployer(AddEmployerRequest addEmployerRequest);

    GetAllEmployersResponse employerToGetAllEmployersResponse(Employer employer);
}
