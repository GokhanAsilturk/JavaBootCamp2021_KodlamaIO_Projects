package gameproject;


import gameproject.Entities.concretes.Campaign;
import gameproject.Entities.concretes.Game;
import gameproject.Entities.concretes.Gamer;
import gameproject.business.abstracts.ICampaignService;
import gameproject.business.abstracts.IGameService;
import gameproject.business.abstracts.IGamerService;
import gameproject.business.concretes.CampaignManager;
import gameproject.business.concretes.GameManager;
import gameproject.business.concretes.GamerManager;
import gameproject.business.concretes.PurchasingManager;
import gameproject.core.Microservices.Adapters.MernisServiceAdapter;
import gameproject.dataAccess.concretes.GameDao;
import gameproject.dataAccess.concretes.GamerDao;


public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("-------------------------------------Entities--------------------------------------------");
        Gamer gamer1 = new Gamer("Gökhan","Asiltürk","18964889850","gokhanasilturkk@gmail.com","25-09-1998");
        Gamer gamer2 = new Gamer("Hakan","Asiltürk","18964889850","hakanasilturkk@gmail.com","27-09-1998");
        Gamer gamers[] = {gamer1,gamer2};

        IGamerService gamerService = new GamerManager(new GamerDao(),new MernisServiceAdapter());
        for(Gamer gamer : gamers) {
            gamerService.add(gamer);
            gamerService.update(gamer);
        }

        System.out.println("----------------------------------Games-----------------------------------------------");

        Game game1 = new Game("Counter Strike",200);
        Game game2 = new Game("Fifa 2020",120);
        Game games[] = {game1,game2};

        IGameService gameService = new GameManager(new GameDao());
        for (Game game : games) {
            gameService.add(game);
            gameService.delete(game);
        }

        System.out.println("-----------------------------------Campaigns----------------------------------------------");
        Campaign campaignHelloween = new Campaign("Helloween",30);
        Campaign campaignNewYear = new Campaign("New Year",25);
        Campaign campaigns[] = {campaignHelloween,campaignNewYear};

        ICampaignService campaignService = new CampaignManager();
        for(Campaign campaign : campaigns){
            for(Game game : games){
                campaignService.calculatedCampaignInfo(campaign,game);
            }
        }
        

       System.out.println("----------------------------------Purchasings-----------------------------------------------");
        PurchasingManager purchasingManager = new PurchasingManager();
        purchasingManager.buy(game1,gamer1);
        purchasingManager.buyWithCampaign(game1,gamer1,campaignHelloween);
        purchasingManager.buyWithCampaign(game2,gamer1,campaignNewYear);







    }
}
