package kodlamaio.hrms.Entities.Concretes;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")


public class Employer extends User{

    @Builder
    public Employer(int id, String emailAddress, String password, String companyName, String website, String phoneNumber) {
        super(id, emailAddress, password);
        this.companyName = companyName;
        this.website = website;
        this.phoneNumber = phoneNumber;

    }




    @Column(name = "companyName")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "phoneNumber")
    private String phoneNumber;





}
