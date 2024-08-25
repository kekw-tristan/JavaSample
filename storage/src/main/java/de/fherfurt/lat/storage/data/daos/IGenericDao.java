package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;

import java.util.Collection;
import java.util.List;

/**
 * Generic Data Access Object (DAO) interface for performing CRUD operations.
 * <p>
 * This interface provides a set of methods for managing entities that extend {@link AbstractDatabaseEntity}.
 * It allows for operations such as finding, creating, updating, and deleting entities.
 * </p>
 *
 * @param <T> the type of entity managed by this DAO, which must extend {@link AbstractDatabaseEntity}.
 */
public interface IGenericDao<T extends AbstractDatabaseEntity> {

    /**
     * Finds an entity by its unique identifier.
     *
     * @param id the unique identifier of the entity.
     * @return the entity with the specified id, or {@code null} if not found.
     */
    T findById(int id);

    /**
     * Retrieves all entities of type {@code T}.
     *
     * @return a collection of all entities.
     */
    Collection<T> findAll();

    /**
     * Creates a new entity in the data store.
     *
     * @param entity the entity to be created.
     * @return {@code true} if the entity was created successfully, {@code false} otherwise.
     */
    boolean create(T entity);

    /**
     * Creates multiple new entities in the data store.
     *
     * @param newEntities a collection of entities to be created.
     * @return {@code true} if all entities were created successfully, {@code false} otherwise.
     */
    boolean createAll(Collection<T> newEntities);

    /**
     * Updates an existing entity in the data store.
     *
     * @param entity the entity with updated values.
     * @return the updated entity.
     */
    T update(T entity);

    /**
     * Deletes an entity by its unique identifier.
     *
     * @param id the unique identifier of the entity to be deleted.
     * @return {@code true} if the entity was deleted successfully, {@code false} otherwise.
     */
    boolean delete(int id);

    /**
     * Deletes an entity.
     *
     * @param entity the entity to be deleted.
     * @return {@code true} if the entity was deleted successfully, {@code false} otherwise.
     */
    boolean delete(T entity);

    /**
     * Deletes multiple entities.
     *
     * @param entries a list of entities to be deleted.
     * @return {@code true} if all entities were deleted successfully, {@code false} otherwise.
     */
    boolean delete(List<T> entries);
}