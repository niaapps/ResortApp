package com.niaapplications.resortapp;

public class Rewards {

    private String businessName;
    private String businessPhoto;
    private String pointsNeeded;
    private String rewardName;


    public Rewards(){
        this.businessName = businessName;
        this.businessPhoto = businessPhoto;
        this.pointsNeeded = pointsNeeded;
        this.rewardName = rewardName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessPhoto() {
        return businessPhoto;
    }

    public void setBusinessPhoto(String businessPhoto) {
        this.businessPhoto = businessPhoto;
    }

    public String getPointsNeeded() {
        return pointsNeeded;
    }

    public void setPointsNeeded(String pointsNeeded) {
        this.pointsNeeded = pointsNeeded;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
}
