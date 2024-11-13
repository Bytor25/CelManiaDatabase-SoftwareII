package co.com.cmdb.generales.application.primaryports.interactor.login;

import java.util.List;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.application.primaryports.interactor.InteractorWithReturn;

public interface ValidarLoginInteractor  extends InteractorWithReturn<LoginDTO, List<LoginDTO>>{

}
