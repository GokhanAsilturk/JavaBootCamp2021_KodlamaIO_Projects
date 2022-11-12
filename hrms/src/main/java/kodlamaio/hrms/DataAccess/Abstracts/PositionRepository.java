package kodlamaio.hrms.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.Entities.Concretes.Position;


public interface PositionRepository extends JpaRepository<Position,Integer> {
}
