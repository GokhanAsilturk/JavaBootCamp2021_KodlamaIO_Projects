package gameproject.business.concretes;


import gameproject.Entities.concretes.Campaign;
import gameproject.Entities.concretes.Game;
import gameproject.business.abstracts.ICampaignService;

public class CampaignManager implements ICampaignService {



    @Override
    public void calculatedCampaignInfo(Campaign campaign, Game game) {
        double discountAmount = game.getPrice()*campaign.getDiscount()/100;
        double discountedPrice = game.getPrice()-discountAmount;

        System.out.println("The discount rate of "+ game.getGameName()+" within the "+campaign.getCampaignName()+" campaign:");
        System.out.println("Price of the "+ game.getGameName()+" without discount: " + game.getPrice());
        System.out.println("The "+ campaign.getCampaignName()+  " campaign has been applied to the game price as - %" + (int)campaign.getDiscount());
        System.out.println("Discounted price: " + discountedPrice);
        System.out.println("Earning: " + discountAmount+ "\n");

    }

    @Override
    public int calculateCampaign(Campaign campaign, Game game) {
        double discountAmount = game.getPrice()*campaign.getDiscount()/100;
        return (int)discountAmount;
    }
}
