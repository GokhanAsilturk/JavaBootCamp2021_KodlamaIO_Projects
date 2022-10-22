package gameproject.dataAccess.abstracts;

import gameproject.Entities.concretes.Gamer;

public interface IGamerDao {
    void add(Gamer gamer);
    void delete(Gamer gamer);
    void update(Gamer gamer);
}
