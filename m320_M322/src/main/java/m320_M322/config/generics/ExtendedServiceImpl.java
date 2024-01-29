package m320_M322.config.generics;

import jakarta.transaction.Transactional;
import m320_M322.config.error.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public abstract class ExtendedServiceImpl<T extends ExtendedEntity> implements ExtendedService<T> {

    protected static final String NO_SUCH_ELEMENT_ERROR_MSG = "Entity with ID '%s' could not be found";
    protected final ExtendedJpaRepository<T> repository;

    protected Logger LOGGER = LoggerFactory.getLogger(ExtendedServiceImpl.class);

    protected ExtendedServiceImpl(ExtendedJpaRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) throws NoSuchElementException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, id));
        }
    }

    @Override
    @Transactional
    public T updateById(UUID id, T entity) throws NoSuchElementException {
        if (repository.existsById(id)) {
            checkUpdatedEntityId(id, entity);
            entity.setId(id);
            return repository.save(entity);
        } else {
            throw new NoSuchElementException(String.format(NO_SUCH_ELEMENT_ERROR_MSG, id));
        }
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(UUID id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    protected void checkUpdatedEntityId(UUID id, T entity){
        LOGGER.debug("id: {}", id);
        LOGGER.debug("entity: {}", entity);

        if (entity.getId() != null) {
            if (id.equals(entity.getId())) {
                return;
            }
            throw new BadRequestException(
                    String.format("Path variable ID '%s' and Request body ID '%s' are not equal", id, entity.getId()));
        }
    }
}
