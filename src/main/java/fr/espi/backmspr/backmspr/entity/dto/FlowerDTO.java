package fr.espi.backmspr.backmspr.entity.dto;

public class FlowerDTO {
    private String flower;
    private String description;
    private Long userid;

    public FlowerDTO(Long id, String description, String flower){
        this.flower = flower;
        this.description = description;
        this.userid = id;
    }

    public String getDescription() {
        return description;
    }

    public String getFlower() {
        return flower;
    }

    public Long getUserId() {
        return userid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public void setUserId(Long userId) {
        this.userid = userId;
    }
}
