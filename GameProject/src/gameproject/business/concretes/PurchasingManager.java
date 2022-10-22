package gameproject.business.concretes;

import gameproject.Entities.concretes.Campaign;
import gameproject.Entities.concretes.Game;
import gameproject.Entities.concretes.Gamer;
import gameproject.business.abstracts.ICampaignService;
import gameproject.business.abstracts.IPurchasingService;

public class PurchasingManager implements IPurchasingService {

    public PurchasingManager() {
    }

    @Override
    public void buy(Game game, Gamer gamer) {
        System.out.println(game.getGameName() + " was purchased by " + gamer.getFirstName() + " " + gamer.getLastName() + " for " + (int) game.getPrice() + "$" + "\n");
    }

    @Override
    public void buyWithCampaign(Game game, Gamer gamer, Campaign campaign) {
        CampaignManager campaignManager = new CampaignManager();
        int discountAmount = campaignManager.calculateCampaign(campaign, game);
        System.out.println(game.getGameName() + " was purchased by " + gamer.getFirstName() + " " + gamer.getLastName() +
                " through the " + campaign.getCampaignName() + " campaign.");

        System.out.println("Price of " + game.getGameName() + " without campaign: " + (int) game.getPrice());
        System.out.println("Price paid by the player: " + ((int) game.getPrice() - discountAmount));
        System.out.println("Player's earnings: " + discountAmount + "\n");

    }
}
