package gameproject.dataAccess.abstracts;

import gameproject.Entities.concretes.Campaign;

public interface ICampaignDao {
    void addCampaign(Campaign campaign);
    void deleteCampagin(Campaign campaign);
    void updateCampaign(Campaign campaign);
}
