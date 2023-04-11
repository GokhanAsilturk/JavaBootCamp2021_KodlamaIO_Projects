package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record AddJobAdvertRequest(

        @NotNull(message = "Company name cannot be left blank!")
        int employerId,
        @NotNull(message = "position name cannot be left blank!")
        int positionId,

        @NotBlank(message = "Title cannot be left blank!")
        String title,
        @NotBlank(message = "description cannot be left blank!")
        String description,
        @NotNull(message = "City cannot be left blank!")
        int cityId,
        int minSalary,
        int maxSalary,
        @NotNull(message = "number of available positions cannot be left blank!")
        int numberOfAvailablePositions,
        @NotBlank
        String deadline
) {

}
