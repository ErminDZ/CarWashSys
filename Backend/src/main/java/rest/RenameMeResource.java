package rest;

import com.google.gson.Gson;
import dtos.BookingDTO;
import dtos.BookingWaDTO;
import entities.Booking;
import entities.User;

import java.sql.*;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import entities.WashingAssistant;
import facades.MainFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class RenameMeResource {


    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    public static final MainFacade MAIN_FACADE = MainFacade.getMainFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("select u from User u", entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public List<User> ShowAllUsers() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u from User u", entities.User.class);
        List<User> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("washingassistant")
    public List<WashingAssistant> ShowAllwashingassistant() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery<WashingAssistant> query = em.createQuery("SELECT wa from WashingAssistant wa", WashingAssistant.class);
        List<WashingAssistant> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("booking")
    @RolesAllowed("user")
    public List<Booking> ShowMyBooking() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery<Booking> query = em.createQuery("SELECT b from Booking b", Booking.class);
        List<Booking> result = query.getResultList();
        return result;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("AddBooking")
    public String createBooking(String jsonString) throws SQLException {
        BookingDTO bDTO = gson.fromJson(jsonString, BookingDTO.class);
        MAIN_FACADE.createBooking(bDTO);
        return "{}";
    }


    public void main(String[] args) throws Exception {
        ShowAllwashingassistant();
        ShowMyBooking();
        createBooking("hej");
    }
}