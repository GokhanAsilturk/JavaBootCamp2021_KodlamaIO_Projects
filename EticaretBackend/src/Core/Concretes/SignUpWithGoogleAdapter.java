package Core.Concretes;

import Business.Abstracts.VerificationServices.EmailVerificationService;
import Business.Abstracts.VerificationServices.UserVerificationService;
import Business.Concretes.UserManager;
import Business.Concretes.VerificationManagers.AbcEmailVerificationManager;
import Business.Concretes.VerificationManagers.RegexUserVerificationManager;
import Core.Abstracts.IRegistrationService;
import Entities.Concretes.User;
import SignUpWithGoogle.SignUpWithGoogleManager;

public class SignUpWithGoogleAdapter implements IRegistrationService{


    @Override
    public void SignUp(User user , String message) {
        UserVerificationService emailVerificationManager = new RegexUserVerificationManager();
        SignUpWithGoogleManager signUpWithGoogleManager = new SignUpWithGoogleManager();

        if(emailVerificationManager.checkEmail(user)){
            signUpWithGoogleManager.signUpWithGoogle(message);
        }else{
            System.out.println("Please enter your google information correctly.");
        }

    }


}
