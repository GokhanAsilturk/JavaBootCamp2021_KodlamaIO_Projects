package kodlamaio.hrms.Entities.Concretes;


import javax.persistence.*;

@Entity
@Table(name = "Positions")
public class Position {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "positionName")
    private String positionName;


    public Position() {
    }

    public Position(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

}
