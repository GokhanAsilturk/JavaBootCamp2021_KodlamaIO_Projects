package gameproject.dataAccess.concretes;

import gameproject.Entities.concretes.Gamer;
import gameproject.dataAccess.abstracts.IGamerDao;

public class GamerDao implements IGamerDao {
    @Override
    public void add(Gamer gamer) {
        System.out.println("Gamer Added: " + gamer.getFirstName() + " " + gamer.getLastName() + " " + "ID - " + gamer.getId() + "\n");
    }

    @Override
    public void delete(Gamer gamer) {
        System.out.println("Gamer Deleted: " + gamer.getFirstName() + " " + gamer.getLastName() + " " + "ID: " + gamer.getId() + "\n");
    }

    @Override
    public void update(Gamer gamer) {
        System.out.println("Gamer Updated: " + gamer.getFirstName() + " " + gamer.getLastName() + " " + "ID: " + gamer.getId() + "\n");
    }
}
