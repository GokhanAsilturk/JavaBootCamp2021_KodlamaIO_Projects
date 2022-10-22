package gameproject.dataAccess.abstracts;

import gameproject.Entities.concretes.Game;

public interface IGameDao {
    void addGame(Game game);
    void deleteGame(Game game);

}
