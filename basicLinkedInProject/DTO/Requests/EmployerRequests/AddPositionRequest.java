package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.NotBlank;


public record AddPositionRequest(
        @NotBlank(message = "position name cannot be left blank!")
        String positionName) {

}
