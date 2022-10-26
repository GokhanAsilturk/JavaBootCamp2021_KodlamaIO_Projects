package Core.Abstracts;

import Entities.Concretes.User;

public interface IRegistrationService {

    void SignUp(User user, String message);

}
