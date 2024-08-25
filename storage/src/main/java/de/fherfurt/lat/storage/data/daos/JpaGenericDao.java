package de.fherfurt.lat.storage.data.daos;

import de.fherfurt.lat.storage.data.core.AbstractDatabaseEntity;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the {@link IGenericDao} interface using JPA (Java Persistence API).
 * <p>
 * This class provides generic DAO operations for entities extending {@link AbstractDatabaseEntity}.
 * It uses JPA's {@link EntityManager} for performing CRUD operations and transactions.
 * </p>
 *
 * @param <T> the type of entity managed by this DAO, which must extend {@link AbstractDatabaseEntity}.
 */
@Getter
public class JpaGenericDao<T extends AbstractDatabaseEntity> implements IGenericDao<T> {

    private final Class<T> persistentClass;
    private final EntityManager entityManager;

    /**
     * Constructs a {@code JpaGenericDao} instance.
     *
     * @param type the class of the entity type.
     * @param em the {@link EntityManager} used to interact with the persistence context.
     */
    public JpaGenericDao(Class<T> type, EntityManager em) {
        this.persistentClass = type;
        this.entityManager = em;
    }

    /**
     * Finds an entity by its unique identifier.
     *
     * @param id the unique identifier of the entity.
     * @return the entity with the specified id, or {@code null} if not found.
     */
    @Override
    public T findById(int id) {
        return getEntityManager().find(persistentClass, id);
    }

    /**
     * Retrieves all entities of type {@code T}.
     *
     * @return a collection of all entities.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Collection<T> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM " + getPersistentClass().getCanonicalName() + " e"
        );
        return (Collection<T>) query.getResultList();
    }

    /**
     * Creates a new entity in the data store.
     *
     * @param entity the entity to be created.
     * @return {@code true} if the entity was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();

        return true;
    }

    /**
     * Creates multiple new entities in the data store.
     *
     * @param newEntities a collection of entities to be created.
     * @return {@code true} if all entities were created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createAll(Collection<T> newEntities) {
        getEntityManager().getTransaction().begin();

        for (T entry : newEntities) {
            getEntityManager().persist(entry);
        }

        getEntityManager().getTransaction().commit();

        return true;
    }

    /**
     * Updates an existing entity in the data store.
     *
     * @param entity the entity with updated values.
     * @return the updated entity.
     */
    @Override
    public T update(T entity) {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();

        return savedEntity;
    }

    /**
     * Deletes an entity by its unique identifier.
     *
     * @param id the unique identifier of the entity to be deleted.
     * @return {@code true} if the entity was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean delete(int id) {
        T entity = this.findById(id);
        return this.delete(entity);
    }

    /**
     * Deletes an entity.
     *
     * @param entity the entity to be deleted.
     * @return {@code true} if the entity was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean delete(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();

        return true;
    }

    /**
     * Deletes multiple entities.
     *
     * @param entries a list of entities to be deleted.
     * @return {@code true} if all entities were deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean delete(List<T> entries) {
        getEntityManager().getTransaction().begin();

        for (T entry : entries) {
            getEntityManager().remove(entry);
        }

        getEntityManager().getTransaction().commit();

        return true;
    }
}