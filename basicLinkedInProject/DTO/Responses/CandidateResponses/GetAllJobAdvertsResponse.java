package kodlamaio.basicLinkedInProject.DTO.Responses.CandidateResponses;

import java.time.LocalDate;

public record GetAllJobAdvertsResponse(

        String title,

        String position,

        String city,

        String companyName,

        String description,

        int minSalary,

        int maxSalary,

        int numberOfAvailablePositions,

        LocalDate deadline,

        String advertSituation
) {


}
