package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.models.Studio;

import java.util.List;
import java.util.Optional;

/**
 * Interface for studio service operations.
 * <p>
 * This interface defines the contract for services that manage studio entities.
 * It provides methods to retrieve, add, and delete studio records.
 * Implementations of this interface are expected to interact with a data repository
 * to perform CRUD operations on studio data.
 * </p>
 */
public interface IStudioService {

    /**
     * Retrieves a list of all studios.
     * <p>
     * This method is used to obtain all studio records from the data source.
     * </p>
     *
     * @return a {@link List} of {@link Studio} objects representing all studios.
     */
    List<Studio> getAllStudios();

    /**
     * Retrieves a specific studio by its ID.
     * <p>
     * This method is used to obtain a studio record by its unique ID.
     * </p>
     *
     * @param studioId the ID of the studio to retrieve.
     * @return an {@link Optional} containing the {@link Studio} if found, or an empty {@link Optional} if not found.
     */
    Optional<Studio> getStudioById(int studioId);

    /**
     * Adds a new studio.
     * <p>
     * This method is used to create a new studio record in the data source.
     * </p>
     *
     * @param studio the {@link Studio} to be added.
     * @return {@code true} if the studio was successfully created, {@code false} otherwise.
     */
    boolean addStudio(Studio studio);

    /**
     * Deletes a specific studio by its ID.
     * <p>
     * This method is used to remove a studio record from the data source based on its unique ID.
     * </p>
     *
     * @param studioId the ID of the studio to be deleted.
     * @return {@code true} if the studio was successfully deleted, {@code false} otherwise.
     */
    boolean deleteStudio(int studioId);
}