package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "washingAssistant")
public class WashingAssistant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "PrimaryLanguage")
    private String primaryLanguage;

    @Column(name = "YearsOfExperience")
    private int yearsOfExperience;

    @Column(name = "PricePrHour")
    private int PricePrHour;

    @ManyToMany
    private List<Booking> bookings = new ArrayList<>();

    public WashingAssistant() {
    }

    public WashingAssistant(Long id, String name, String primaryLanguage, int yearsOfExperience, int pricePrHour) {
        this.id = id;
        this.name = name;
        this.primaryLanguage = primaryLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.PricePrHour = pricePrHour;
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