package m320_M322.webcontext.domain.authority;

import m320_M322.config.generics.ExtendedService;

public interface AuthorityService extends ExtendedService<Authority> {

    /**
     * find the authority by its name
     *
     * @param name String of authority
     * @return the authority object
     * @see Authority
     */
    Authority findByName(String name);

    /**
     * delete a given authority by its name
     *
     * @param name String of authority
     * @see Authority
     */
    void deleteByName(String name);
}
