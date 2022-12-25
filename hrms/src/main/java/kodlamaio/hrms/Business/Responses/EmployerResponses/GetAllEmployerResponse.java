package kodlamaio.hrms.Business.Responses.EmployerResponses;

import kodlamaio.hrms.Entities.Concretes.Candidate;
import kodlamaio.hrms.Entities.Concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployerResponse {
    private int id;
    private String companyName;
    private String website;
    private String emailAddress;
    private String phoneNumber;

    public GetAllEmployerResponse(Employer employer) {

        this.id = employer.getId();
        this.companyName = employer.getCompanyName();
        this.website = employer.getWebsite();
        this.phoneNumber = employer.getPhoneNumber();
        this.emailAddress = employer.getEmailAddress();
    }

}

