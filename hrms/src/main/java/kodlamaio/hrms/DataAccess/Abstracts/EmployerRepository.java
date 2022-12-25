package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Integer> {

    boolean existsByEmailAddress(String emailAddress);
}
