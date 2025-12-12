package co.parameta.tecnical.test.commons.repository;

import co.parameta.tecnical.test.commons.entity.AdministratorUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorUserRepository extends JpaRepository<AdministratorUserEntity, String> {

    Optional<AdministratorUserEntity> findByCode(String code);

}
