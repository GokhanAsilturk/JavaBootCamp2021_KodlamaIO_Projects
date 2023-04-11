package kodlamaio.basicLinkedInProject.DataAccess;


import kodlamaio.basicLinkedInProject.Entities.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertRepository extends JpaRepository<JobAdvert, Integer> {

    List<JobAdvert> getByAdvertSituationTrue();

    @Modifying
    //Hangi durumdaysa tersine çevirmek için aşağıdaki kodu kullanabiliriz.
    //@Query("UPDATE JobAdvert e SET e.advertSituation = CASE WHEN e.advertSituation = true THEN false ELSE true END WHERE e.id = :id")
    @Query("UPDATE JobAdvert e SET e.advertSituation = false WHERE e.id = :id")
    void updateAdvertSituationToFalse(@Param("id") int id);

    @Modifying
    @Query("UPDATE JobAdvert e SET e.advertSituation = true WHERE e.id = :id")
    void updateAdvertSituationToTrue(@Param("id") int id);

}
