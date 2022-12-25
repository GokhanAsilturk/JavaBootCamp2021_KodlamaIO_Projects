package kodlamaio.hrms.Business.Abstracts;

import kodlamaio.hrms.Business.Requests.EmployerRequests.AddEmployerRequest;
import kodlamaio.hrms.Business.Responses.EmployerResponses.GetAllEmployerResponse;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;
public interface EmployerService {

    Result add(AddEmployerRequest addEmployerRequest);

    DataResult<List<GetAllEmployerResponse>> getAll();

    DataResult<GetAllEmployerResponse> getById(int id);

}
