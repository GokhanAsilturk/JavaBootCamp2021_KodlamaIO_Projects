package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.Business.Abstracts.PositionService;
import kodlamaio.hrms.Business.Requests.PositionRequests.AddPositionRequest;
import kodlamaio.hrms.Business.Responses.PositionResponses.GetAllPositionsResponse;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/position")
public class PositionsController {

    private PositionService positionService;

    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public DataResult<List<GetAllPositionsResponse>> getAllPositions() {
        return this.positionService.getAll();
    }

    @PostMapping
    public Result add(@Valid @RequestBody AddPositionRequest addPositionRequest) {
        return positionService.add(addPositionRequest);
    }
}
