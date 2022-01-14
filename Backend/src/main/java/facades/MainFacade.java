package facades;

import dtos.BookingDTO;
import dtos.BookingWaDTO;
import dtos.RenameMeDTO;
import dtos.WashingAssistantDTO;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.awt.print.Book;

public class MainFacade {
    private static EntityManagerFactory emf;
    private static MainFacade instance;

    private MainFacade() {
    }

    /**
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

    public BookingDTO createBooking(BookingDTO bDTO){
        Booking booking = new Booking(bDTO.getDateAndTime(),bDTO.getDuration());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BookingDTO(booking);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}


