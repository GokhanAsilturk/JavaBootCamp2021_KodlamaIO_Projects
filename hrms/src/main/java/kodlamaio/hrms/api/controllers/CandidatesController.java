package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.Business.Abstracts.CandidateService;
import kodlamaio.hrms.Business.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.hrms.Business.Responses.CandidateResponses.GetAllCandidateResponse;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/candidates")
public class CandidatesController {


    private CandidateService candidateService;

    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    DataResult<List<GetAllCandidateResponse>> getAll(){
        return candidateService.getAll();
    }

    @PostMapping //@valid validasyon için.
    public Result add(@Valid @RequestBody AddCandidateRequest addCandidateRequest){

        return candidateService.add(addCandidateRequest);
    }

@GetMapping("/{id}")
DataResult<GetAllCandidateResponse> getById(@PathVariable int id ){
    return candidateService.getById(id);
}

}
