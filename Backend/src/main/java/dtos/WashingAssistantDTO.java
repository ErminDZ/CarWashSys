package dtos;

import entities.WashingAssistant;

public class WashingAssistantDTO {
    private Long id;
    private String name;
    private String primaryLanguage;
    private int yearsOfExperience;
    private int PricePrHour;


    public WashingAssistantDTO(WashingAssistant waDTO) {
        this.id = waDTO.getId();
        this.name = waDTO.getName();
        this.primaryLanguage = waDTO.getPrimaryLanguage();
        this.yearsOfExperience = waDTO.getYearsOfExperience();
        PricePrHour = waDTO.getPricePrHour();
    }

    public WashingAssistantDTO(Long id, String name, String primaryLanguage, int yearsOfExperience, int pricePrHour) {
        this.id = id;
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        PricePrHour = pricePrHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getPricePrHour() {
        return PricePrHour;
    }

    public void setPricePrHour(int pricePrHour) {
        PricePrHour = pricePrHour;
    }
}
