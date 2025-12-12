package co.parameta.tecnical.test.commons.repository;

import co.parameta.tecnical.test.commons.entity.ScriptValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptValidationRepository extends JpaRepository<ScriptValidationEntity, String> {


}
