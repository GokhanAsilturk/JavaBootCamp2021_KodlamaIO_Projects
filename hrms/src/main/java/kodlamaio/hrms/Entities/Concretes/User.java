package kodlamaio.hrms.Entities.Concretes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED) //


@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "email",unique = true)
    private String emailAddress;

    @Column(name = "password")
    private String password;

}
