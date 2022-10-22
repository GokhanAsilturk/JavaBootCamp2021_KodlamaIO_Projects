package gameproject.business.abstracts;

import gameproject.Entities.concretes.Campaign;
import gameproject.Entities.concretes.Game;
import gameproject.Entities.concretes.Gamer;

public interface IPurchasingService {
    void buy(Game game, Gamer gamer);
    public void buyWithCampaign(Game game, Gamer gamer, Campaign campaign);
}
