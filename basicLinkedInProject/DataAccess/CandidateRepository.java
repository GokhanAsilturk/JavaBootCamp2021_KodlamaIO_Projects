package kodlamaio.basicLinkedInProject.DataAccess;

import kodlamaio.basicLinkedInProject.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    boolean existsByEmailAdress(String emailAddress);
}
