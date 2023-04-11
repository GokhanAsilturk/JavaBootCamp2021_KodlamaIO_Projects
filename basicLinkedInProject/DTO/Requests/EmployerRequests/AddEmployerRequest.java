package kodlamaio.basicLinkedInProject.DTO.Requests.EmployerRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public record AddEmployerRequest(
        @NotBlank(message = "Company name cannot be left blank!")
        String companyName,

        @Size(min = 7, max = 50)
        @NotBlank(message = "Email adress cannot be left blank!")
        @Email
        String emailAddress,


        @NotBlank(message = "Password cannot be left blank")
        @Size(min = 8, max = 30, message = "Password must be a minimum of 8 characters and a maximum of 30 characters.")
        String password) {


}
