package Business.Abstracts;

import Core.Abstracts.IRegistrationService;
import Entities.Concretes.User;

public interface UserService {

    void logIn(String email,String password);
    void signUp(User user);
    void signUpWithAdapter(User user, IRegistrationService registrationService);

}
