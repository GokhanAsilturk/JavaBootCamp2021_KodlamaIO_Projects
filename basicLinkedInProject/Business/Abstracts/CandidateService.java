package kodlamaio.basicLinkedInProject.Business.Abstracts;

import kodlamaio.basicLinkedInProject.DTO.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllEmployersResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllJobAdvertsResponse;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;

import java.util.List;

public interface CandidateService {

    Result add(AddCandidateRequest addCandidateRequest);

    DataResult<List<GetAllEmployersResponse>> getAllEmployers();

    DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdverts();

    DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsByEmployer(int employerId);

    DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsSortedByDeadline();
}
