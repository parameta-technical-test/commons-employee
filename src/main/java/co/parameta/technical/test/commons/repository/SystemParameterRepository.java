package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.SystemParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemParameterRepository extends JpaRepository<SystemParameterEntity, Integer> {
}
