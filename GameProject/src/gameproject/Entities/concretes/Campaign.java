package gameproject.Entities.concretes;

import gameproject.Entities.abstracts.IEntities;

public class Campaign implements IEntities {
    private double discount;
    private String campaignName;

    public Campaign() {
    }

    public Campaign(String campaignName,double discount) {
        this.discount = discount;
        this.campaignName = campaignName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
