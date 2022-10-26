package Business.Abstracts.VerificationServices;

import Entities.Concretes.User;

public interface EmailVerificationService {

    void sendVerifyEmail(User user);
    boolean ClickedVerifyLink(User user);
    boolean emailIsValid(User user);




}
