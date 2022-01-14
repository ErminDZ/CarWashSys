package dtos;

import java.time.LocalDateTime;

public class BookingWaDTO {
    private LocalDateTime dateAndTime;
    private int duration;
    private Long registrationNumber;
    private String username;

    public BookingWaDTO(LocalDateTime dateAndTime, int duration, Long registrationNumber, String username) {
        this.dateAndTime = dateAndTime;
        this.duration = duration;
        this.registrationNumber = registrationNumber;
        this.username = username;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
