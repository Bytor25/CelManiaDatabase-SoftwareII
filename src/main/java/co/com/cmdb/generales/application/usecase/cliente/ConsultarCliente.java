package co.com.cmdb.generales.application.usecase.cliente;

import java.util.List;

import co.com.cmdb.generales.application.usecase.UseCaseWithReturn;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;

public interface ConsultarCliente extends UseCaseWithReturn<ClienteDomain, List<ClienteDomain>>{

}
