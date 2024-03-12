package fr.espi.backmspr.backmspr.entity.dto;

public class FlowerDTO {
    private String flower;
    private String description;
    private Long userid;
    private Double longitude;
    private Double latitude;
    private String locationName;
    private String titre;



    public FlowerDTO(Long id, String description, String flower, Double latitude, Double longitude ,String locationName , String titre){
        this.flower = flower;
        this.description = description;
        this.userid = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
        this.titre = titre;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public String getLocationName() {
        return locationName;
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

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
