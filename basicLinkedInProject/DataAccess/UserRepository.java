package kodlamaio.basicLinkedInProject.DataAccess;


import kodlamaio.basicLinkedInProject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
