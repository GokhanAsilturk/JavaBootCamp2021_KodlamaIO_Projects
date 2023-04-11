package kodlamaio.basicLinkedInProject.Business.Abstracts;

import kodlamaio.basicLinkedInProject.Entities.User;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;

import java.util.List;

public interface UserService {

    Result add(User user);

    DataResult<List<User>> getAll();
}
