package kodlamaio.hrms.Business.Verifications;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;

//Mernis doğrulaması
public class MernisVerification {

    public Result verify(String name , String surname, String nationalID, int dateOFBirth){

        if(name.isEmpty()||surname.isEmpty()||nationalID.isEmpty()||dateOFBirth<1950){
            throw new IllegalArgumentException("Mernis authentication failed !!");
        }

        return new SuccessResult("Mernis verification successful");

    }
}
