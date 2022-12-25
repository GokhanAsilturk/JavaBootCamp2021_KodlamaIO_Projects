package kodlamaio.hrms.Business.Requests.CandidateRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCandidateRequest {

    @Size(min = 3, max = 20)
    @NotBlank(message = "Name cannot be left blank!") //validasyon için boş req gelmesini engeller.
    private String name;

    @Size(min = 3, max = 20)
    @NotBlank(message = "Surname cannot be left blank!")
    private String surname;

    @Size(min = 11, max = 11)
    @NotBlank(message = "National ID cannot be left blank!")
    private String nationalID;

    @Min(1950)
    @Max(2020)
    private int yearOfBirth;

    @Size(min = 7 ,max = 50)
    @NotBlank(message = "Email adress cannot be left blank!")
    @Email
    private String emailAddress;


    @NotBlank(message = "Password cannot be left blank")
    @Size(min = 8, max = 30, message = "Password must be a minimum of 8 characters and a maximum of 30 characters.")
    private String password;

    @NotBlank
    @Size(min = 8, max = 30, message = "Passwords do not match")
    private String repeatPassword;


}
