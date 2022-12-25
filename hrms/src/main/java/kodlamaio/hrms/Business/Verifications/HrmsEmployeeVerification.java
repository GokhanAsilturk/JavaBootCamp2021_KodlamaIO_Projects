package kodlamaio.hrms.Business.Verifications;


import kodlamaio.hrms.Entities.Concretes.Employer;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResults.SuccessResult;

public class HrmsEmployeeVerification {


    public Result verifyEmployer(Employer employer){

        return new SuccessResult("Verified employer, by employee");
    }

}
