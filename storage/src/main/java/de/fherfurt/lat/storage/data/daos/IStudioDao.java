package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.models.Studio;
import de.fherfurt.lat.storage.models.Address;
import java.util.List;

public interface IStudioDao extends IGenericDao<Studio>
{
    int GetIdByStudio(Studio studio);

    List<Studio> findWithAddress(Address address);
}
