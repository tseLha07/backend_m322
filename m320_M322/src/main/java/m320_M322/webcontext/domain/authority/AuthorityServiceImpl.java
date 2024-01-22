package m320_M322.webcontext.domain.authority;


import java.util.NoSuchElementException;
import lombok.extern.log4j.Log4j2;
import m320_M322.config.generics.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authority findByName(String name) {
        log.trace("trying to find authority by name");
        Authority result = ((AuthorityRepository) repository).findByName(name)
                .orElseThrow(() -> new NoSuchElementException(String.format("Authority with name '%s' not found", name)));
        log.debug("successfully found authority by name");
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteByName(String name) {
        log.trace("trying to delete Authority by name");
        ((AuthorityRepository) repository).deleteByName(name);
        log.debug("successfully deleted authority by name");
    }

    /**
     * delete an authority by its id
     *
     * @param id String of authority
     * @throws NoSuchElementException if the authority was not found in the database
     * @see Authority
     */
    @Override
    public void deleteById(String id) throws NoSuchElementException {
        log.trace("trying to delete authority with id: " + id);
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(String.format("Authority with ID '%s' not found", id));
        }
        ((AuthorityRepository) repository).deleteRelationsToRolesById(id);
        repository.deleteById(id);
        log.debug("successfully deleted authority with id: " + id);
    }
}
