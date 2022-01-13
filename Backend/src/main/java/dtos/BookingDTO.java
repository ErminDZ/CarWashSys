package dtos;

import entities.Booking;

import java.time.LocalDateTime;

public class BookingDTO {
    private Long booking_id;
    private LocalDateTime dateAndTime;
    private int duration;

    public BookingDTO(Booking bDTO) {
        this.booking_id = bDTO.getBooking_id();
        this.dateAndTime = bDTO.getDateAndTime();
        this.duration = bDTO.getDuration();
    }

    public BookingDTO(Long booking_id, LocalDateTime dateAndTime, int duration) {
        this.booking_id = booking_id;
        this.dateAndTime = dateAndTime;
        this.duration = duration;
    }

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
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
}
