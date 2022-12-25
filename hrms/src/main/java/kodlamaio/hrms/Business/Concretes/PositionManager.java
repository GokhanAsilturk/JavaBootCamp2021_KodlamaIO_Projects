package kodlamaio.hrms.Business.Concretes;

import kodlamaio.hrms.Business.Abstracts.PositionService;
import kodlamaio.hrms.Business.Requests.PositionRequests.AddPositionRequest;
import kodlamaio.hrms.Business.Responses.PositionResponses.GetAllPositionsResponse;
import kodlamaio.hrms.DataAccess.Abstracts.PositionRepository;
import kodlamaio.hrms.Entities.Concretes.Position;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionRepository positionRepository;


    @Autowired
    public PositionManager(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public DataResult<List<GetAllPositionsResponse>> getAll() {

        List<GetAllPositionsResponse> responseList = new ArrayList<GetAllPositionsResponse>();

        for (Position position : this.positionRepository.findAll()) {
            GetAllPositionsResponse responseItem = new GetAllPositionsResponse();
            responseItem.setName(position.getName());
            responseList.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllPositionsResponse>>(responseList,"Data Listelendi");
    }

    @Override
    public Result add(AddPositionRequest addPositionRequest) {

        Position position = new Position();

        position.setName(addPositionRequest.getName());

        positionRepository.save(position);
        return new SuccessResult("Position added to DB: " + position.getName());
    }


}
