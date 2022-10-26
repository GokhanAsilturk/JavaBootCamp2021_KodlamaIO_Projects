package Business.Abstracts.VerificationServices;

import Entities.Concretes.User;

public interface UserVerificationService {

    boolean checkFirstName(User user);
    boolean checkLastName(User user);
    boolean checkEmail(User user);
    boolean checkPassword(User user);
    boolean userIsValid(User user);
}
