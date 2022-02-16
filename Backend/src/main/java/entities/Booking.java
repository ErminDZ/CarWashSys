package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long booking_id;

    @Column(name = "DateAndTime")
    private LocalDateTime dateAndTime;

    @Column(name = "Duration")
    private int duration;

    @ManyToOne
    private Car car;

    @ManyToMany(mappedBy = "bookings", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WashingAssistant> washingAssistants;

    public Booking() {
    }

    public Booking(Long booking_id, LocalDateTime dateAndTime, int duration, Car car) {
        this.booking_id = booking_id;
        this.dateAndTime = dateAndTime;
        this.duration = duration;
        this.car = car;
    }

    public Booking(LocalDateTime dateAndTime, int duration) {
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<WashingAssistant> getWashingAssistants() {
        return washingAssistants;
    }

    public void addWashingAssistants(WashingAssistant washingAssistant) {
        this.washingAssistants.add(washingAssistant);
    }
}
