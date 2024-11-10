package co.com.cmdb.generales.application.primaryports.interactor.cliente;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.interactor.InteractorWithoutReturn;

@Service
@Transactional
public interface RegistrarClienteInteractor extends InteractorWithoutReturn<ClienteDTO> {

}
