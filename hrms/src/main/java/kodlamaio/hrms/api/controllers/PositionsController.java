package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.Business.Abstracts.PositionService;
import kodlamaio.hrms.Entities.Concretes.Position;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/api/positions")
public class PositionsController {

    private PositionService positionService;

    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getAllPositions")
    public List<Position> getAllPositions() {return this.positionService.getAll();}
}
