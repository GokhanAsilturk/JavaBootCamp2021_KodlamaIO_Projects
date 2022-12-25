package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.Business.Abstracts.EmployerService;
import kodlamaio.hrms.Business.Requests.EmployerRequests.AddEmployerRequest;
import kodlamaio.hrms.Business.Responses.EmployerResponses.GetAllEmployerResponse;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/api/employers")
public class EmployersController {

    EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }





    @PostMapping
    public Result add(@Valid @RequestBody AddEmployerRequest addEmployerRequest){
        return this.employerService.add(addEmployerRequest);
    }

    @GetMapping
    DataResult<List<GetAllEmployerResponse>> getAll(){
        return this.employerService.getAll();
    }


    @GetMapping("/{id}")
    DataResult<GetAllEmployerResponse> getById(@PathVariable int id){
        return employerService.getById(id);
    }


}

