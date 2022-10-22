package gameproject.dataAccess.concretes;

import gameproject.Entities.concretes.Campaign;
import gameproject.dataAccess.abstracts.ICampaignDao;

public class CampaignDao implements ICampaignDao {
    @Override
    public void addCampaign(Campaign campaign) {
        System.out.println("Campaign Added: " + campaign.getCampaignName());
    }

    @Override
    public void deleteCampagin(Campaign campaign) {
        System.out.println("Campaign Deleted: " + campaign.getCampaignName());
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        System.out.println("Campaign Updated: " + campaign.getCampaignName());
    }
}
