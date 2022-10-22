package gameproject.Entities.concretes;

import gameproject.Entities.abstracts.IEntities;

public class Game implements IEntities {

    private String gameName;
    private double price;


    public Game() {
    }

    public Game(String gameName, double price) {
        this.gameName = gameName;
        this.price = price;
    }


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
