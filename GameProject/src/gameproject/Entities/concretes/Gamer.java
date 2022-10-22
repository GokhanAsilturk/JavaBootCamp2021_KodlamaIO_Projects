package gameproject.Entities.concretes;

import gameproject.Entities.abstracts.IEntities;
import gameproject.business.TranslateManager;


public class Gamer implements IEntities {
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String email;
    private String dateOfBirth;

    public Gamer() {

    }

    public Gamer(String firstName, String lastName, String nationalIdentity, String email, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {

        TranslateManager translate = new TranslateManager();
        return translate.TurkishToEnglish(firstName.substring(0,1)+lastName.substring(0,1)+nationalIdentity.substring(0,3)).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
