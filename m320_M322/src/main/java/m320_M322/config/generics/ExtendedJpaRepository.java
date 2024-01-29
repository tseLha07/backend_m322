package m320_M322.config.generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository<T, Integer> {
}