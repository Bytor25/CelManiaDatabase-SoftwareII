package co.com.cmdb.generales.application.secondaryports.repository.login;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.cmdb.generales.application.secondaryports.entity.LoginEntity;

@Repository
public interface LoginRepositoryCustom {
	
	List<LoginEntity> selectByFilter(LoginEntity filter);
}
