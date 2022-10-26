package Business.Concretes.VerificationManagers;

import Business.Abstracts.VerificationServices.UserVerificationService;
import Entities.Concretes.User;

import java.util.regex.Pattern;

public class RegexUserVerificationManager implements UserVerificationService {


    public RegexUserVerificationManager() {

    }

    @Override
    public boolean checkFirstName(User user) {

        return user.getFirstName().length() >= 2;
    }

    @Override
    public boolean checkLastName(User user) {

        return user.getLastName().length() >= 2;
    }

    @Override
    public boolean checkEmail(User user) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (user.getEmail().isEmpty()) {
            System.out.println("Cannot be empty 'E-Mail'.");
            return false;
        } else if (pattern.matcher(user.getEmail()).find() == false) {
            System.out.println("The entered email address is not valid. Example: example@example.com");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkPassword(User user) {

        return user.getPassword().length() >= 6;
    }

    @Override
    public boolean userIsValid(User user) {
        if (checkFirstName(user)==false && checkLastName(user)==false) {
            System.out.println("Name and surname must be at least two letters.!");
        }
        if (checkPassword(user)==false){
            System.out.println("Password must be at least 6 letters.!");
        }else{
            System.out.println("Your registration is in progress..");
        }
        return (checkFirstName(user) && checkLastName(user) && checkPassword(user) && checkEmail(user));
    }
}
