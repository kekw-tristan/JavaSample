package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.models.Studio;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class JpaStudioDao extends JpaGenericDao<Studio> implements IStudioDao
{
    public JpaStudioDao(EntityManager em)
    {
        super(Studio.class, em);
    }

    @Override
    public int GetIdByStudio(Studio studio) {
        return 0;
    }
}
