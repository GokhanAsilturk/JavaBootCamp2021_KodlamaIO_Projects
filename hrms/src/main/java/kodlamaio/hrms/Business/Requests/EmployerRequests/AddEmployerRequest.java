package kodlamaio.hrms.Business.Requests.EmployerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddEmployerRequest {

    @Size(min = 3, max = 50)
    @NotBlank(message = "Company name cannot be left blank!")
    private String companyName;

    @Size(min = 6 ,max = 100)
    @NotBlank(message = "Website cannot be left blank!")
    @URL(message = "Make sure you typed the website address correctly.")
    private String website;

    @Size(min = 7 ,max = 50)
    @NotBlank(message = "Email address cannot be left blank!")
    @Email
    private String emailAddress;

    @Size(min = 10 ,max = 10)
    @NotBlank(message = "Phone number cannot be left blank!")
    private String phoneNumber;

    @Size(min = 8 ,max = 30)
    @NotBlank(message = "Password cannot be left blank!")
    private String password;

    @Size(min = 8 ,max = 30)
    @NotBlank(message = "Message cannot be left blank!")
    private String repeatPassword;
}
