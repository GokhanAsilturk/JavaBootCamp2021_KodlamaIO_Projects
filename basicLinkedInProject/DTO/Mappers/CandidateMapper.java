package kodlamaio.basicLinkedInProject.DTO.Mappers;

import kodlamaio.basicLinkedInProject.DTO.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.basicLinkedInProject.Entities.Candidate;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CandidateMapperImpl", componentModel = "spring")
public interface CandidateMapper {


    Candidate addCandidateRequestToCandidate(AddCandidateRequest addCandidateRequest);

}

