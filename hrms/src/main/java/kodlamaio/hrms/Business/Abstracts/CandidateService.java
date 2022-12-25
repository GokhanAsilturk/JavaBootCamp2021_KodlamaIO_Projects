package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Business.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.hrms.Business.Responses.CandidateResponses.GetAllCandidateResponse;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

public interface CandidateService {

    Result add(AddCandidateRequest addCandidateRequest);

    public DataResult<List<GetAllCandidateResponse>> getAll();


    DataResult<GetAllCandidateResponse> getById(int id);


}
