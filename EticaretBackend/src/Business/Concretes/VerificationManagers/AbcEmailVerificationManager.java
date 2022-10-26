package Business.Concretes.VerificationManagers;

import Business.Abstracts.VerificationServices.EmailVerificationService;
import Entities.Concretes.User;

public class AbcEmailVerificationManager implements EmailVerificationService {


    @Override
    public void sendVerifyEmail(User user) {
        System.out.println("Verification link sent to " + user.getEmail());
    }

    @Override
    public boolean ClickedVerifyLink(User user) {
        return true;
    }

    @Override
    public boolean emailIsValid(User user) {
        sendVerifyEmail(user);
        if(ClickedVerifyLink(user)){
            System.out.println("Email verification successful.");
        }else {
            System.out.println("Please check the verification email.");
        }
        return ClickedVerifyLink(user);
    }
}
