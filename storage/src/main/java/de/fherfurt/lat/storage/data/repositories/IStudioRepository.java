package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Studio;

import java.util.List;

public interface IStudioRepository {
    List<Studio> getAllStudios();

    Studio getStudio( int studioId );
    boolean createStudio( Studio studio );
    boolean updateStudio( Studio studio );
    boolean deleteStudio( int studioId );
}