package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.models.Address;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class JpaAddressDao extends JpaGenericDao<Address> implements IAddressDao
{
    public JpaAddressDao(EntityManager em)
    {
        super(Address.class, em);
    }

    @Override
    public int GetIdByAddress(Address address) {
        return 0;
    }
}
