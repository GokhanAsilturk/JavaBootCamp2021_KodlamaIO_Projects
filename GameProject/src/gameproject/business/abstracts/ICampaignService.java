package gameproject.business.abstracts;

import gameproject.Entities.concretes.Campaign;
import gameproject.Entities.concretes.Game;

public interface ICampaignService {

    void calculatedCampaignInfo(Campaign campaign, Game game);

    int calculateCampaign(Campaign campaign, Game game);


}
