package co.parameta.tecnical.test.commons.repository;

import co.parameta.tecnical.test.commons.entity.BlacklistTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistTokenRepository extends JpaRepository<BlacklistTokenEntity, String> {
}
