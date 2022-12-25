package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {



}
