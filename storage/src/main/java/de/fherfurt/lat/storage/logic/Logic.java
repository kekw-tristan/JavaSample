package de.fherfurt.lat.storage.logic;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;
import de.fherfurt.lat.storage.models.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Logic
{

    // Database members
    private DatabaseConnection db;

    public void init()
    {
        ConnectDatabase();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lat-unit");
        EntityManager entityManager = factory.createEntityManager();

        Address a = new Address(14, "street1", "99869", "Erfurt", "Germany");
        Address b = new Address(14, "street2", "99869", "Erfurt", "Germany");
        Address c = new Address(14, "street3", "99869", "Erfurt", "Germany");

        entityManager.getTransaction().begin();
        entityManager.persist(a);

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.persist(b);
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    public void run()
    {
    }

    public void fin()
    {
        if(!db.closeDatabaseConnection())
            System.out.println("Could not close Database!");
    }

    private void ConnectDatabase()
    {
        final int port          = 3306;
        final String host       = "localhost";
        final String database   = "javaprojekt";
        final String username   = "user";
        final String password   = "password";
        final String url        = "jdbc:mariadb://" + host + ":" + port + "/" + database;

        db = DatabaseConnection.getInstance();

        if(!db.connectToDatabase(url, username, password))
            System.out.println("Connection to Database failed!");

    }
}
