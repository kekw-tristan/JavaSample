package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.models.Studio;

public interface IStudioDao extends IGenericDao<Studio>
{
    public int GetIdByStudio(Studio studio);
}
