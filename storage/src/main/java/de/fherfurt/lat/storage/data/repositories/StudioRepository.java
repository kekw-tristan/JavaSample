package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.data.daos.IStudioDao;
import de.fherfurt.lat.storage.models.Address;
import de.fherfurt.lat.storage.models.Studio;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class StudioRepository implements IStudioRepository{
    private final IGenericDao<Studio> studioDao;

    @Override
    public List<Studio> getAllStudios() {
        return new ArrayList<>(studioDao.findAll());
    }

    @Override
    public Studio getStudio( int studioId ) {
        return studioDao.findById(studioId);
    }

    @Override
    public boolean createStudio( Studio studio ) {
        return studioDao.create(studio);
    }

    @Override
    public boolean updateStudio( Studio studio ) {
        Studio updatedStudio = studioDao.update(studio);
        return updatedStudio.equals(studio);
    }

    @Override
    public boolean deleteStudio( int studioId ) {
        return studioDao.delete(studioId);
    }
}
