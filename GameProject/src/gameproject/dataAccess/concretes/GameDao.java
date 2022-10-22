package gameproject.dataAccess.concretes;

import gameproject.Entities.concretes.Game;
import gameproject.dataAccess.abstracts.IGameDao;

public class GameDao implements IGameDao {
    @Override
    public void addGame(Game game) {
        System.out.println("Game Added: " + game.getGameName() + "\n");
    }

    @Override
    public void deleteGame(Game game) {
        System.out.println("Game Deleted: " + game.getGameName() + "\n");
    }
}
