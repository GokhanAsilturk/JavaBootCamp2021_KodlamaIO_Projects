package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.NotBlank;


public record AddCityRequest(

        @NotBlank(message = "City cannot be left blank!")
        String cityName) {

}
