package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.AdministratorUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA repository for managing {@link AdministratorUserEntity}.
 * <p>
 * Provides database access methods to retrieve administrator
 * users by their unique code or email address.
 */
@Repository
public interface AdministratorUserRepository
        extends JpaRepository<AdministratorUserEntity, String> {

    /**
     * Finds an administrator user by its unique code.
     *
     * @param code unique administrator user identifier
     * @return an {@link Optional} containing the user if found
     */
    Optional<AdministratorUserEntity> findByCode(String code);

    /**
     * Finds an administrator user by email address.
     *
     * @param code administrator user email
     * @return an {@link Optional} containing the user if found
     */
    Optional<AdministratorUserEntity> findByEmail(String code);
}
