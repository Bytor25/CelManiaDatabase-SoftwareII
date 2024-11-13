package co.com.cmdb.generales.application.secondaryports.repository.login;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, UUID>, LoginRepositoryCustom{

}
