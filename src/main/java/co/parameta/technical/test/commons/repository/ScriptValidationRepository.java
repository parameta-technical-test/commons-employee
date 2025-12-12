package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.ScriptValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptValidationRepository extends JpaRepository<ScriptValidationEntity, String> {


}
