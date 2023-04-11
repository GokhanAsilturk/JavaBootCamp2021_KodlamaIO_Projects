package kodlamaio.basicLinkedInProject.api.Controllers;

import kodlamaio.basicLinkedInProject.Business.Abstracts.CandidateService;
import kodlamaio.basicLinkedInProject.DTO.Requests.CandidateRequests.AddCandidateRequest;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllEmployersResponse;
import kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses.GetAllJobAdvertsResponse;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/candidate")
public class CandidatesController {


    private final CandidateService candidateService;

    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddCandidateRequest addCandidateRequest) {
        return this.candidateService.add(addCandidateRequest);
    }

    @GetMapping("/getAllEmployers")
    public DataResult<List<GetAllEmployersResponse>> getAllEmployers() {
        return this.candidateService.getAllEmployers();
    }

    @GetMapping("/getAllJobAdverts")
    public DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdverts() {
        return this.candidateService.getAllJobAdverts();
    }

    @GetMapping("/getAllJobAdvertsByEmployer")
    DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsByEmployer(@RequestParam int employerId) {
        return this.candidateService.getAllJobAdvertsByEmployer(employerId);
    }

    @GetMapping("/getAllJobAdvertsByDeadline")
    DataResult<List<GetAllJobAdvertsResponse>> getAllJobAdvertsByDeadline() {
        return this.candidateService.getAllJobAdvertsSortedByDeadline();
    }


}
