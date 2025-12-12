package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.BlacklistTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistTokenRepository extends JpaRepository<BlacklistTokenEntity, String> {

    boolean existsByToken(String token);

}
