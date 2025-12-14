package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.ScriptValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for managing {@link ScriptValidationEntity}.
 * <p>
 * Provides basic CRUD operations for validation scripts stored in the database.
 * These scripts are typically used for dynamic business validations executed
 * through Groovy at runtime.
 */
@Repository
public interface ScriptValidationRepository extends JpaRepository<ScriptValidationEntity, String> {

}
