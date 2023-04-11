package kodlamaio.basicLinkedInProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")

@JsonIgnoreProperties({"hibernateLazyInıtializer", "handler", "jobAdverts"})
// sonsuz döngüye girildiğinde işlemi durdurması için. Lazy load yaptırırız.
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    //employer a, hangi iş ilanlarına sahip olduğunu kaydediyoruz.
    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;


}
