package co.parameta.technical.test.commons.repository;

import co.parameta.technical.test.commons.entity.AdministratorUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorUserRepository extends JpaRepository<AdministratorUserEntity, String> {

    Optional<AdministratorUserEntity> findByCode(String code);

    Optional<AdministratorUserEntity> findByEmail(String code);


}
