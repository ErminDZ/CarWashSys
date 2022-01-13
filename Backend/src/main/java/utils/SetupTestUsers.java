package utils;


import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    // user / admin
    User user = new User("user", "1234");
    User admin = new User("admin", "12345");
    User both = new User("user_admin", "1234");

    // boats
    Boat boat1 = new Boat(1, "Bertram", "Bertram", "Bertram 800", "bertram.jpeg");
    Boat boat2 = new Boat(2, "Boston Whaler", "Boston Whaler", "Montauk", "boston-whaler.jpeg");
    Boat boat3 = new Boat(3, "Chapparal", "Chapparal", "SSX", "chapparal.jpeg");
    Boat boat4 = new Boat(4, "Grady White", "Grady White", "The Canyon 336", "grady-white.jpeg");
    Boat boat5 = new Boat(5, "Lund", "Lund", "PRO-V BASS XS", "lund.jpeg");
    Boat boat6 = new Boat(6, "Masterchef", "Mastercraft", "NXT", "mastercraft.jpeg");
    Boat boat7 = new Boat(7, "Sea Ray", "Sea Ray", "SUN SPORT 230", "sea-ray.jpeg");
    Boat boat8 = new Boat(8, "Tracker", "Tracker", "DEEP V", "tracker.jpeg");
    Boat boat9 = new Boat(9, "Vking Yacths", "Viking Yacths", "92EB", "viking-yachts.jpeg");
    Boat boat10 = new Boat(10, "Yamaha", "Yamaha", "19 FT", "yamaha.jpeg");

    // owners
    Owner owner1 = new Owner(1, "Guinevere", "773 Judy Alley", 645746);
    Owner owner2 = new Owner(2, "Tammara", "32 Annamark Way", 7439755);
    Owner owner3 = new Owner(3, "Saxe", "998 Lakewood Center", 850502);
    Owner owner4 = new Owner(4, "Rob", "579 Shopko Avenue", 395467);
    Owner owner5 = new Owner(5, "Algernon", "32 Emmet Circle", 316256);
    Owner owner6 = new Owner(6, "Normy", "34 Springview Alley", 621683);
    Owner owner7 = new Owner(7, "Joycelin", "1248 Eggendart Court", 741665);
    Owner owner8 = new Owner(8, "Hali", "8 Spaight Court", 655738);
    Owner owner9 = new Owner(9, "Vernon", "875 American Ash Avenue", 833832);
    Owner owner10 = new Owner(10, "Jonathan", "1 Oakridge Pass", 452221);

    // harbours
    Harbour harbour1 = new Harbour(1, "Sydney", "Sydney Harbour Bridge, Sydney NSW, Australia", 50);
    Harbour harbour2 = new Harbour(2, "Kotor", "Montenegro", 100);
    Harbour harbour3 = new Harbour(3, "Victoria Harbour", "Admiralty, Hong Kong", 1000);
    Harbour harbour4 = new Harbour(4, "Neko Harbour", "Antarctica", 50);
    Harbour harbour5 = new Harbour(5, "Rio de Janeiro", "Brazil", 50);
    Harbour harbour6 = new Harbour(6, "Stockholm", "Sweden", 50);
    Harbour harbour7 = new Harbour(7, "English Harbour", "Antigua", 50);
    Harbour harbour8 = new Harbour(8, "Vancouver", "Canada", 50);
    Harbour harbour9 = new Harbour(9, "Mo’orea", "French Polynesia", 50);
    Harbour harbour10 = new Harbour(10, "Port of Shanghai", "Shanghai", 50);


    // check if you can get username and password
    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();

    // boats
    em.persist(boat1);
    em.persist(boat2);
    em.persist(boat3);
    em.persist(boat4);
    em.persist(boat5);
    em.persist(boat6);
    em.persist(boat7);
    em.persist(boat8);
    em.persist(boat9);
    em.persist(boat10);

    // owners
    em.persist(owner1);
    em.persist(owner2);
    em.persist(owner3);
    em.persist(owner4);
    em.persist(owner5);
    em.persist(owner6);
    em.persist(owner7);
    em.persist(owner8);
    em.persist(owner9);
    em.persist(owner10);

    // harbours
    em.persist(harbour1);
    em.persist(harbour2);
    em.persist(harbour3);
    em.persist(harbour4);
    em.persist(harbour5);
    em.persist(harbour6);
    em.persist(harbour7);
    em.persist(harbour8);
    em.persist(harbour9);
    em.persist(harbour10);

    // adding user / admin roles
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);

    // commit multiple transactions
    em.getTransaction().commit();

    // print to console
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
