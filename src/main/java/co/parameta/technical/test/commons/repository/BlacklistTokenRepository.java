package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.BlacklistTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for managing {@link BlacklistTokenEntity}.
 * <p>
 * Provides database access methods for checking the existence of tokens
 * in the blacklist, based on a given token string.
 */
@Repository
public interface BlacklistTokenRepository extends JpaRepository<BlacklistTokenEntity, String> {

    /**
     * Checks if a token is present in the blacklist.
     *
     * @param token the token string to check
     * @return {@code true} if the token exists in the blacklist, {@code false} otherwise
     */
    boolean existsByToken(String token);
}
