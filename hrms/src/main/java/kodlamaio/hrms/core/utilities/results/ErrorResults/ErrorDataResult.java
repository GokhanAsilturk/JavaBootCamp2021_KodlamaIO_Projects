package kodlamaio.hrms.core.utilities.results.ErrorResults;

import kodlamaio.hrms.core.utilities.results.DataResult;

public class ErrorDataResult<T> extends DataResult<T> {


    public ErrorDataResult(T data, String message) {

        super(data, false, message);
    }

    public ErrorDataResult(T data) {

        super(data,false);
    }

    public ErrorDataResult(String message) {

        super(null, false, message);
    }


    public ErrorDataResult() {
        super(null,false);
    }

}
