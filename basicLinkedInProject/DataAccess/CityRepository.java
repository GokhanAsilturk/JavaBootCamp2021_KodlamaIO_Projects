package kodlamaio.basicLinkedInProject.DataAccess;

import kodlamaio.basicLinkedInProject.Entities.DataBaseEntities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
