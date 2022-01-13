package dtos;

import entities.Car;

public class CarDTO {
    private Long registrationNumber;
    private String brand;
    private String make;
    private int year;

    public CarDTO(Long registrationNumber, String brand, String make, int year) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.make = make;
        this.year = year;
    }

    public CarDTO(Car cDTO) {
        this.registrationNumber = cDTO.getRegistrationNumber();
        this.brand = cDTO.getBrand();
        this.make = cDTO.getMake();
        this.year = cDTO.getYear();
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
