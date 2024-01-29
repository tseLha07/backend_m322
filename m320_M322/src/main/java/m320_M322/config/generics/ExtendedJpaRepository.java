package m320_M322.config.generics;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository<T, Integer> {
}