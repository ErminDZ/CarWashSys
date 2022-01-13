package facades;

import dtos.BookingDTO;
import entities.Booking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainFacade {
    private static EntityManagerFactory emf;
    private static MainFacade instance;

    private MainFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static MainFacade getMainFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MainFacade();
        }
        return instance;
    }

    public BookingDTO getBookingById(long id) {
        EntityManager em = emf.createEntityManager();
        Booking booking = em.find(Booking.class, id);
        return new BookingDTO(booking);
    }
}
