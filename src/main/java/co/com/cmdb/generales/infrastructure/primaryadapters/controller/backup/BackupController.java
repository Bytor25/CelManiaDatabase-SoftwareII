package co.com.cmdb.generales.infrastructure.primaryadapters.controller.backup;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import co.com.cmdb.generales.infrastructure.secondaryadapters.service.backup.BackupService;

import java.io.IOException;

@RestController
@RequestMapping("/api/storage")
public class BackupController {

    private final BackupService BackupService;

    public BackupController(BackupService BackupService) {
        this.BackupService = BackupService;
    }

    // Endpoint para subir un archivo
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = BackupService.uploadFile(file);
            return new ResponseEntity<>("Archivo subido exitosamente: " + fileUrl, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error al subir el archivo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para descargar un archivo
    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        byte[] fileData = BackupService.downloadFile(fileName);
        
        if (fileData != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
            return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un archivo
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        String result = BackupService.deleteFile(fileName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

