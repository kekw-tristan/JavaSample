package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.models.Address;

public interface IAddressDao extends IGenericDao<Address>
{
    public int GetIdByAddress(Address address);
}
