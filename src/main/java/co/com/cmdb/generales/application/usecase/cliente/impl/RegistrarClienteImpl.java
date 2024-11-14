package co.com.cmdb.generales.application.usecase.cliente.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.com.cmdb.generales.application.secondaryports.entity.ClienteEntity;
import co.com.cmdb.generales.application.secondaryports.mapper.TipoDocumentoEntityMapper;
import co.com.cmdb.generales.application.secondaryports.repository.cliente.ClienteRepository;
import co.com.cmdb.generales.application.secondaryports.service.keyvault.VaultService;
import co.com.cmdb.generales.application.secondaryports.service.notification.NotificationService;
import co.com.cmdb.generales.application.secondaryports.vo.Email;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarCliente;
import co.com.cmdb.generales.application.usecase.cliente.RegistrarClienteRuleValidator;
import co.com.cmdb.generales.crosscutting.exceptions.UseCaseCmdbException;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import co.com.cmdb.generales.domain.cliente.ClienteDomain;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;


@Service
public class RegistrarClienteImpl implements RegistrarCliente {

    private final ClienteRepository clienteRepository;
    private final RegistrarClienteRuleValidator registrarClienteRuleValidator;
    private final MessageCatalogService messageCatalogService;
    private final NotificationService notificationService;
    private final VaultService vaultService;

    public RegistrarClienteImpl(final ClienteRepository clienteRepository, 
                                final RegistrarClienteRuleValidator registrarClienteRuleValidator, 
                                final MessageCatalogService messageCatalogService,
                                final NotificationService notificationService, 
                                final VaultService vaultService) {

        if (ObjectHelper.isNull(clienteRepository) || ObjectHelper.isNull(registrarClienteRuleValidator)) {
            var userMessage = messageCatalogService.getMessage("errorRegistroCliente");
            var technicalMessage = messageCatalogService.getMessage("errorServiciosRegistarCt");
            throw new UseCaseCmdbException(userMessage, technicalMessage, new Exception());
        }

        this.clienteRepository = clienteRepository;
        this.registrarClienteRuleValidator = registrarClienteRuleValidator;
        this.messageCatalogService = messageCatalogService;
        this.notificationService = notificationService;
        this.vaultService = vaultService;
    }

    @Override
    public void execute(final ClienteDomain cliente) {
        registrarClienteRuleValidator.validate(cliente);
        var id = generarIdentificadorCliente();
        
        var clienteEntity = ClienteEntity.create()
            .setId(id)
            .setTipoDocumento(TipoDocumentoEntityMapper.INSTANCE.toEntity(cliente.getTipoDocumento()))
            .setNumeroDocumento(cliente.getNumeroDocumento())
            .setNombre(cliente.getNombre())
            .setApellidos(cliente.getApellidos())
            .setCorreo(cliente.getCorreo())
            .setTelefono(cliente.getTelefono());

        clienteRepository.save(clienteEntity);

        String template = vaultService.getSecretValue("ContentEmail");
        String clientName = cliente.getNombre();
        String body = template.replace("${clientName}", clientName);
        Email email = Email.create(body);
        
        notificationService.send(email);
    }

    private UUID generarIdentificadorCliente() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while (existeId) {
            id = UUIDHelper.generate();
            var resultados = clienteRepository.findById(id);
            existeId = !resultados.isEmpty();
        }

        return id;
    }
}



