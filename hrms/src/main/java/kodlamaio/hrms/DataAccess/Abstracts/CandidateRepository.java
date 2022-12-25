package kodlamaio.hrms.DataAccess.Abstracts;

import kodlamaio.hrms.Entities.Concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {

    boolean existsByEmailAddress(String emailAddress);
}
