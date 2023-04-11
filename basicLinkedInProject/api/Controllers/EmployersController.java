package kodlamaio.basicLinkedInProject.api.Controllers;

import kodlamaio.basicLinkedInProject.Business.Abstracts.EmployerService;
import kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests.*;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllCitiesResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.EmployerResponses.GetAllPositionsResponse;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employer")
public class EmployersController {

    private final EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddEmployerRequest addEmployerRequest) {
        return this.employerService.add(addEmployerRequest);
    }

    @PostMapping("/addJobAdvert")
    public Result add(@RequestBody AddJobAdvertRequest addJobAdvertRequest) {
        return this.employerService.addJobAdvert(addJobAdvertRequest);
    }

    @PostMapping("/deActivateJobAdvert")
    public Result deActivateJobAdvert(@RequestBody DeActivateJobAdvertRequest deActivateJobAdvertRequest) {
        return this.employerService.deActivateJobAdvert(deActivateJobAdvertRequest);
    }


    @PostMapping("/activateJobAdvert")
    public Result activateJobAdvert(@RequestBody ActivateJobAdvertRequest activateJobAdvertRequest) {

        return this.employerService.activateJobAdvert(activateJobAdvertRequest);
    }

    @PostMapping("/addPosition")
    public Result addPosition(@RequestBody AddPositionRequest addPositionRequest) {
        return this.employerService.addPosition(addPositionRequest);
    }

    @PostMapping("/addCity")
    public Result addCity(@RequestBody AddCityRequest addCityRequest) {
        return this.employerService.addCity(addCityRequest);
    }

    @GetMapping("/getAllCities")
    public DataResult<List<GetAllCitiesResponse>> getAllCities() {
        return this.employerService.getAllCities();
    }

    @GetMapping("/getAllPositions")
    public DataResult<List<GetAllPositionsResponse>> getAllPositions() {
        return this.employerService.getAllPositions();
    }

}
