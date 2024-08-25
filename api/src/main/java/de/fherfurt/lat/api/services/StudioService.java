package de.fherfurt.lat.api.services;

import de.fherfurt.lat.storage.data.core.DataController;
import de.fherfurt.lat.storage.data.repositories.IStudioRepository;
import de.fherfurt.lat.storage.models.Studio;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing studio entities.
 * <p>
 * This class implements the {@link IStudioService} interface, providing the actual
 * functionality for retrieving, adding, and deleting studios. It interacts with
 * the {@link IStudioRepository} to perform CRUD operations on studio data.
 * </p>
 */
public class StudioService implements IStudioService {

    private final IStudioRepository studioRepository;

    /**
     * Default constructor that initializes the service with the studio repository obtained from the {@link DataController}.
     */
    public StudioService() {
        this(DataController
                .getInstance()
                .getStudioRepository());
    }

    /**
     * Constructor that allows for dependency injection of the studio repository.
     *
     * @param studioRepository the {@link IStudioRepository} to be used by this service.
     */
    public StudioService(IStudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    /**
     * Retrieves a list of all studios.
     * <p>
     * This method fetches all studio records from the data source.
     * </p>
     *
     * @return a {@link List} of {@link Studio} objects representing all studios.
     */
    @Override
    public List<Studio> getAllStudios() {
        return studioRepository.getAllStudios();
    }

    /**
     * Retrieves a specific studio by its ID.
     * <p>
     * This method fetches a studio record by its unique ID from the data source.
     * </p>
     *
     * @param studioId the ID of the studio to retrieve.
     * @return an {@link Optional} containing the {@link Studio} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<Studio> getStudioById(int studioId) {
        return Optional.ofNullable(studioRepository.getStudio(studioId));
    }

    /**
     * Adds a new studio.
     * <p>
     * This method creates a new studio record in the data source.
     * </p>
     *
     * @param studio the {@link Studio} to be added.
     * @return {@code true} if the studio was successfully created, {@code false} otherwise.
     */
    @Override
    public boolean addStudio(Studio studio) {
        return studioRepository.createStudio(studio);
    }

    /**
     * Deletes a specific studio by its ID.
     * <p>
     * This method removes a studio record from the data source based on its unique ID.
     * </p>
     *
     * @param studioId the ID of the studio to be deleted.
     * @return {@code true} if the studio was successfully deleted, {@code false} otherwise.
     */
    @Override
    public boolean deleteStudio(int studioId) {
        return studioRepository.deleteStudio(studioId);
    }
}