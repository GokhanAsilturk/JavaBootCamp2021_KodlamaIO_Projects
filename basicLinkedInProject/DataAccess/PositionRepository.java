package kodlamaio.basicLinkedInProject.DataAccess;

import kodlamaio.basicLinkedInProject.Entities.DataBaseEntities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
