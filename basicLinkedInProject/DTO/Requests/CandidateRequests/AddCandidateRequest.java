package kodlamaio.basicLinkedInProject.DTO.Requests.CandidateRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public record AddCandidateRequest(
        @Size(min = 3, max = 20)
        @NotBlank(message = "Name cannot be left blank!") //validasyon için boş req gelmesini engeller.
        String name,

        @Size(min = 3, max = 20)
        @NotBlank(message = "Surname cannot be left blank!")
        String surname,

        @Min(18)
        int age,

        @NotBlank(message = "City cannot be left blank!")
        String city,

        @NotBlank(message = "Profession cannot be left blank!")
        String profession,

        @Size(min = 7, max = 50)
        @NotBlank(message = "Email adress cannot be left blank!")
        @Email
        String emailAddress,

        @NotBlank(message = "Password cannot be left blank")
        @Size(min = 8, max = 30, message = "Password must be a minimum of 8 characters and a maximum of 30 characters.")
        String password
) {

}
