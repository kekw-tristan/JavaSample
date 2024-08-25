package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.data.daos.IGenericDao;
import de.fherfurt.lat.storage.models.Studio;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link IStudioRepository} interface for managing {@link Studio} entities.
 * <p>
 * This class uses a generic DAO for performing CRUD operations on {@link Studio} entities.
 * It provides implementations for retrieving, creating, and deleting studio records from the data store.
 * </p>
 */
@AllArgsConstructor
public class StudioRepository implements IStudioRepository {
    private final IGenericDao<Studio> studioDao;

    /**
     * Retrieves all studio entities from the data store.
     *
     * @return a list of all studios.
     */
    @Override
    public List<Studio> getAllStudios() {
        return new ArrayList<>(studioDao.findAll());
    }

    /**
     * Retrieves a specific studio entity by its unique identifier.
     *
     * @param studioId the unique identifier of the studio.
     * @return the studio with the specified ID, or {@code null} if not found.
     */
    @Override
    public Studio getStudio(int studioId) {
        return studioDao.findById(studioId);
    }

    /**
     * Creates a new studio entity in the data store.
     *
     * @param studio the studio to be created.
     * @return {@code true} if the studio was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createStudio(Studio studio) {
        return studioDao.create(studio);
    }

    /**
     * Deletes a studio entity from the data store using its unique identifier.
     *
     * @param studioId the unique identifier of the studio to be deleted.
     * @return {@code true} if the studio was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean deleteStudio(int studioId) {
        return studioDao.delete(studioId);
    }
}