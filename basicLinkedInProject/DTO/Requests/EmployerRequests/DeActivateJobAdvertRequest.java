package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.NotNull;


public record DeActivateJobAdvertRequest(
        @NotNull(message = "job id cannot be left blank!")
        int jobId
) {


}
