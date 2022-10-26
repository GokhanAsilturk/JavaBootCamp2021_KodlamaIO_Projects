import Business.Concretes.UserManager;
import Business.Concretes.VerificationManagers.AbcEmailVerificationManager;
import Business.Concretes.VerificationManagers.RegexUserVerificationManager;
import Core.Concretes.SignUpWithGoogleAdapter;
import DataAccess.Concretes.SqlUserDao;
import Entities.Concretes.User;

public class Main {

    public static void main(String[] args) {


    User user1 = new User("Gökhan","Asiltürk","gokhanasilturkk@gmail.com","defegrht553344");
    User user2 = new User("Engin","Demiroğ","engindemirog@gmail.com","l0s0fneujxs");
    UserManager userManager = new UserManager(new AbcEmailVerificationManager(),new RegexUserVerificationManager(), new SqlUserDao());

    userManager.signUp(user1);
    userManager.logIn("gokhanasilturkk@gmail.com","defegrht553344");
    userManager.signUpWithAdapter(user1, new SignUpWithGoogleAdapter());

    userManager.signUp(user2);
    userManager.logIn("engindemirog@gmail.com","l0s0fneujxs");
    userManager.signUpWithAdapter(user2, new SignUpWithGoogleAdapter());







    }
}
