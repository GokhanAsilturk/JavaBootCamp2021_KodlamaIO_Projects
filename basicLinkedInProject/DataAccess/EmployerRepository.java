package kodlamaio.basicLinkedInProject.DataAccess;


import kodlamaio.basicLinkedInProject.Entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {



    boolean existsByCompanyName(String companyName);

    boolean existsByEmailAddress(String emailAddress);

}
