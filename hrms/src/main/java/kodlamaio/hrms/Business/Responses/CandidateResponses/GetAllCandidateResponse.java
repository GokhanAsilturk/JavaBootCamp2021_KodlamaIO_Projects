package kodlamaio.hrms.Business.Responses.CandidateResponses;

import kodlamaio.hrms.Entities.Concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCandidateResponse {

    private int id;
    private String name;
    private String surname;
    private String nationalID;
    private int yearOfBirth;
    private String emailAddress;


    public GetAllCandidateResponse(Candidate candidate) {

        this.id = candidate.getId();
        this.name = candidate.getName();
        this.surname = candidate.getSurname();
        this.nationalID = candidate.getNationalID();
        this.yearOfBirth = candidate.getYearOfBirth();
        this.emailAddress = candidate.getEmailAddress();
    }
}
