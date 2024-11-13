package co.com.cmdb.generales.infrastructure.primaryadapters.controller.tipodocumento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;
import co.com.cmdb.generales.application.primaryports.interactor.tipodocumento.TipoDocumentoInteractor;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.infrastructure.primaryadapters.controller.response.TipoDocumentoResponse;

@RestController  
@RequestMapping("/generales/api/v1/tiposdocumento")
public class TipoDocumentoController {

    private final TipoDocumentoInteractor tipoDocumentoInteractor;

    // Inyección de dependencias a través del constructor
    public TipoDocumentoController(TipoDocumentoInteractor tipoDocumentoInteractor) {
        this.tipoDocumentoInteractor = tipoDocumentoInteractor;
    }

    @GetMapping
    public ResponseEntity<TipoDocumentoResponse> consultar() {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoDocumentoResponse = new TipoDocumentoResponse();

        try {
            var tipoDocumentoDto = TipoDocumentoDTO.create();

            tipoDocumentoResponse.setDatos(tipoDocumentoInteractor.execute(tipoDocumentoDto));
            tipoDocumentoResponse.getMensajes().add("Tipos de documento consultados de manera exitosa");

        } catch (CmdbException exception) {

            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoDocumentoResponse.getMensajes().add(exception.getMessage());
            exception.printStackTrace();

        } catch (Exception exception) {

            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var userMessage = "Error al consultar los estados...";
            tipoDocumentoResponse.getMensajes().add(userMessage);
            exception.printStackTrace();

        }

        return new ResponseEntity<>(tipoDocumentoResponse, httpStatusCode);
    }

}
