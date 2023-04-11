package kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllEmployersResponse {
    String companyName;
    String emailAddress;

}
