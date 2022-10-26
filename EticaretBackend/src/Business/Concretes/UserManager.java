package Business.Concretes;

import Business.Abstracts.UserService;
import Business.Abstracts.VerificationServices.EmailVerificationService;
import Business.Abstracts.VerificationServices.UserVerificationService;
import Core.Abstracts.IRegistrationService;
import DataAccess.Abstracts.IUserDao;
import Entities.Concretes.User;

import java.util.List;

public class UserManager implements UserService {


    private EmailVerificationService emailVerificationManager;
    private UserVerificationService userVerificationManager;
    private IUserDao userDao;


    public UserManager(EmailVerificationService emailVerificationManager, UserVerificationService userVerificationManager, IUserDao userDao) {
        this.emailVerificationManager = emailVerificationManager;
        this.userVerificationManager = userVerificationManager;
        this.userDao = userDao;
    }

    public UserManager() {
    }

    @Override
    public void logIn(String email, String password) {
        List<User> newUserList = userDao.getAllUsers();
        boolean situation = true;
        for (User user : newUserList) {

            if (user.getEmail() == email & user.getPassword() == password) {
                System.out.println("Logged in: " + user.getFirstName() + " " + user.getLastName());
            } else if (email == null && password == null) {
                situation = false;
                System.out.println("Fill in all the information!");
            }
        }
        if(!situation){
            System.out.println("Your e-mail or password is wrong!");
        }
        System.out.println("\n");
    }


    @Override
    public void signUp(User user) {
        if (userVerificationManager.userIsValid(user) && emailVerificationManager.emailIsValid(user)) {
            System.out.println("Registration Successful.");
            userDao.add(user);
            System.out.println("\n");
        }

    }

    @Override
    public void signUpWithAdapter(User user, IRegistrationService registrationService) {
        registrationService.SignUp(user, user.getFirstName() + " " + user.getLastName() + " Registration Successful With ");
        System.out.println("\n");

    }


}
