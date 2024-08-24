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

        Address a = new Address(12, "street 1", "54233", "Erfurt", "Germany");
        Address b = new Address(14, "street 2", "45342", "Erfurt", "Germany");
        Address c = new Address(14, "street 3", "12342", "Erfurt", "Germany");

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

        db.connectToDatabase();

    }
}
