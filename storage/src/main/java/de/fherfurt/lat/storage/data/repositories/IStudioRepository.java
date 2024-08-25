package de.fherfurt.lat.storage.data.repositories;

import de.fherfurt.lat.storage.models.Studio;

import java.util.List;

/**
 * Repository interface for managing {@link Studio} entities.
 * <p>
 * This interface defines methods for performing CRUD (Create, Read, Update, Delete) operations
 * on {@link Studio} entities. Implementations of this interface are responsible for
 * interacting with the underlying data store.
 * </p>
 */
public interface IStudioRepository {

    /**
     * Retrieves all studio entities from the data store.
     *
     * @return a list of all studios.
     */
    List<Studio> getAllStudios();

    /**
     * Retrieves a specific studio entity by its unique identifier.
     *
     * @param studioId the unique identifier of the studio.
     * @return the studio with the specified id, or {@code null} if not found.
     */
    Studio getStudio(int studioId);

    /**
     * Creates a new studio entity in the data store.
     *
     * @param studio the studio to be created.
     * @return {@code true} if the studio was created successfully, {@code false} otherwise.
     */
    boolean createStudio(Studio studio);

    /**
     * Deletes a studio entity from the data store using its unique identifier.
     *
     * @param studioId the unique identifier of the studio to be deleted.
     * @return {@code true} if the studio was deleted successfully, {@code false} otherwise.
     */
    boolean deleteStudio(int studioId);
}