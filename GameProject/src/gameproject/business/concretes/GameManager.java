package gameproject.business.concretes;

import gameproject.Entities.concretes.Game;
import gameproject.business.abstracts.IGameService;
import gameproject.dataAccess.abstracts.IGameDao;

public class GameManager implements IGameService {

    IGameDao gameDao;

    public GameManager(IGameDao gameDao) {
        this.gameDao = gameDao;
    }

    public GameManager() {
    }

    @Override
    public void add(Game game) {
        gameDao.addGame(game);
    }

    @Override
    public void delete(Game game) {
        gameDao.deleteGame(game);
    }
}
