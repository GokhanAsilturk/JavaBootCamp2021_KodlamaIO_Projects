package kodlamaio.basicLinkedInProject.Business.Concretes;

import kodlamaio.basicLinkedInProject.Business.Abstracts.UserService;
import kodlamaio.basicLinkedInProject.Entities.User;
import kodlamaio.basicLinkedInProject.core.Results.DataResult;
import kodlamaio.basicLinkedInProject.core.Results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    @Override
    public Result add(User user) {
        return null;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return null;
    }
}
