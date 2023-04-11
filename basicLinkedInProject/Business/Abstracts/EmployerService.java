package kodlamaio.basicLinkedInProject.Business.Abstracts;

import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.*;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllCitiesResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllPositionsResponse;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;

import java.util.List;

public interface EmployerService {

    Result add(AddEmployerRequest addEmployerRequest);

    Result addJobAdvert(AddJobAdvertRequest addJobAdvertRequest);

    Result deActivateJobAdvert(DeActivateJobAdvertRequest deActivateJobAdvertRequest);

    Result activateJobAdvert(ActivateJobAdvertRequest activateJobAdvertRequest);

    Result addPosition(AddPositionRequest addPositionRequest);

    Result addCity(AddCityRequest addCityRequest);

    DataResult<List<GetAllCitiesResponse>> getAllCities();

    DataResult<List<GetAllPositionsResponse>> getAllPositions();
}
