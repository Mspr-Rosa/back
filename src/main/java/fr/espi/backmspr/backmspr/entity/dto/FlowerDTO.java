package fr.espi.backmspr.backmspr.entity.dto;

public class FlowerDTO {
    private String flower;
    private String description;
    private int userid;

    public String getDescription() {
        return description;
    }

    public String getFlower() {
        return flower;
    }

    public int getUserId() {
        return userid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }
}
