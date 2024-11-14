package co.com.cmdb.generales.domain.cliente.rules.impl.telefono;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.domain.cliente.exceptions.telefono.ClienteTelefonoRangeIsNotValidException;
import co.com.cmdb.generales.domain.cliente.rules.telefono.ClienteTelefonoRangeIsValidRule;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@Service
public class ClienteTelefonoRangeIsValidImpl implements ClienteTelefonoRangeIsValidRule{

	private MessageCatalogService messageCatalogService;
	
	public ClienteTelefonoRangeIsValidImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}
	
	@Override
	public void execute(Long data) {
		if(!NumericHelper.validarRangoTelefono(data)) {
		throw ClienteTelefonoRangeIsNotValidException.create(messageCatalogService);
		}
	}

}
