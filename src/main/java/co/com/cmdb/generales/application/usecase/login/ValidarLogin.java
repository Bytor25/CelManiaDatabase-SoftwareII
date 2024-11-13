package co.com.cmdb.generales.application.usecase.login;

import java.util.List;

import co.com.cmdb.generales.application.usecase.UseCaseWithReturn;
import co.com.cmdb.generales.domain.login.LoginDomain;

public interface ValidarLogin extends UseCaseWithReturn<LoginDomain, List<LoginDomain>>{

}
