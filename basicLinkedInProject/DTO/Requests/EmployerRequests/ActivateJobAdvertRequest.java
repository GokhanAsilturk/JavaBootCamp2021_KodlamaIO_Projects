package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.NotNull;


public record ActivateJobAdvertRequest( // record = dataların değiştirilmesini önlemek amacıyla kullanırız.
                                        //Data ve getter setter anotasyonlarına ihtiyaç duymayız
                                        @NotNull(message = "Job id cannot be left blank!")
                                        int jobId
) {

}
