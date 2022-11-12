package kodlamaio.hrms.Business.Concretes;

import kodlamaio.hrms.Business.Abstracts.PositionService;
import kodlamaio.hrms.DataAccess.Abstracts.PositionRepository;
import kodlamaio.hrms.Entities.Concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PositionManager implements PositionService {

    private PositionRepository positionRepository;


    @Autowired
    public PositionManager(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getAll() {
        System.out.println("All Positions :\n");
        return this.positionRepository.findAll();
    }


}
