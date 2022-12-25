package kodlamaio.hrms.Business.Abstracts;


import kodlamaio.hrms.Business.Requests.PositionRequests.AddPositionRequest;
import kodlamaio.hrms.Business.Responses.PositionResponses.GetAllPositionsResponse;
import kodlamaio.hrms.Entities.Concretes.Position;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

public interface PositionService {


    DataResult<List<GetAllPositionsResponse>> getAll();

    Result add(AddPositionRequest addPositionRequest);
}
