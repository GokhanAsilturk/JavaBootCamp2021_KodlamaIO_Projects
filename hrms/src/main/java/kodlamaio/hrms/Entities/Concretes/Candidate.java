package kodlamaio.hrms.Entities.Concretes;


import kodlamaio.hrms.Business.Requests.CandidateRequests.AddCandidateRequest;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")


public class Candidate extends User{

    //Builder çalıştığında user daki fieldları verebilmek için user nesnelerinin bulunduğu yeni bir constructor açtık.
    @Builder
    public Candidate(int id, String emailAddress, String password, String name, String surname, String nationalID, int yearOfBirth) {
        super(id, emailAddress, password);
        this.name = name;
        this.surname = surname;
        this.nationalID = nationalID;
        this.yearOfBirth = yearOfBirth;
    }



    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @Column(name = "nationalID", unique = true)
    private String nationalID;

    @Column(name = "yearOfBirth")
    private int yearOfBirth;








}
