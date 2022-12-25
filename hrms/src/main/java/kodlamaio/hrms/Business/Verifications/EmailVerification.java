package kodlamaio.hrms.Business.Verifications;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;

//Email doğrulaması
public class EmailVerification {

    public Result sentEmail(String emailAddress){


        return new SuccessResult("Verification mail sent to " + emailAddress);
    }

}
