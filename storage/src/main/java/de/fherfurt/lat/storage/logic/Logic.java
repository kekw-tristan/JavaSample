package de.fherfurt.lat.storage.logic;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;
import de.fherfurt.lat.storage.data.daos.JpaAddressDao;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;

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
        JpaAddressDao addressDao = new JpaAddressDao(entityManager);

        Address a = new Address(12, "41", "5", "2", "3");
        Address b = new Address(14, "123", "45", "345", "234");
        Address c = new Address(14, "123", "123", "123", "123");

        addressDao.create(a);
        addressDao.create(b);
        addressDao.create(c);

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
