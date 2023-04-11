package kodlamaio.basicLinkedInProject.Entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advert_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "position")
    private int positionId;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private int cityId;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "number_of_available_positions")
    @Min(value = 1, message = "Number of available positions must be 1 or more!")
    private int numberOfAvailablePositions;
    @Column(name = "deadline")
    private LocalDate deadline;
    @Column(name = "advert_situation")
    private boolean advertSituation = true;
    //iş ilanına, hangi employer ın olduğu bilgisini kaydediyoruz.
    @ManyToOne
    @JoinColumn(name = "employer_")
    private Employer employer;


    public JobAdvert(String title, int positionId, String description,
                     int cityId, int minSalary, int maxSalary, int numberOfAvailablePositions,
                     Employer employer) {
        this.title = title;
        this.positionId = positionId;
        this.description = description;
        this.cityId = cityId;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.numberOfAvailablePositions = numberOfAvailablePositions;
        this.employer = employer;
    }
}
