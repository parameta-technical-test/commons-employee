package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.SystemParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for managing {@link SystemParameterEntity}.
 * <p>
 * Provides access to application and business configuration parameters
 * stored in the database, allowing dynamic behavior control without
 * requiring code changes or redeployments.
 */
@Repository
public interface SystemParameterRepository extends JpaRepository<SystemParameterEntity, Integer> {

    /**
     * Retrieves a system parameter by its unique name.
     *
     * @param name the parameter name
     * @return the matching {@link SystemParameterEntity}, or {@code null} if not found
     */
    SystemParameterEntity findByName(String name);

}
