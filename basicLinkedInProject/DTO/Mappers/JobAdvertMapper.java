package kodlamaio.basicLinkedInProject.DTO.Mappers;

import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.AddJobAdvertRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllJobAdvertsResponse;
import kodlamaio.basicLinkedInProject.Entities.JobAdvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobAdvertMapper {

    JobAdvert addJobAdvertRequestToJobAdvert(AddJobAdvertRequest addJobAdvertRequest);

    GetAllJobAdvertsResponse jobAdvertToGetAllJobAdvertsResponse(JobAdvert jobAdvert);
}
