package co.com.cmdb.generales.infrastructure.secondaryadapters.servicesblobstorage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import co.com.cmdb.generales.application.primaryports.dto.UploadFileDTO;
import co.com.cmdb.generales.init.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    
	@Value("${blobstorage.connection}")
	private String blobstorageconnection;
	
	@Override
    public String uploadFileAzure(UploadFileDTO uploadFileDTO) {
        String resultService = "";
        String storageConnectionAzure = blobstorageconnection;
        String nameContainer = "contenedor1";

        try {
      
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(storageConnectionAzure)
                    .buildClient();

  
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(nameContainer);


            if (!containerClient.exists()) {
                containerClient.create();
            }

  
            BlobClient blobClient = containerClient.getBlobClient(uploadFileDTO.getName());

 
            byte[] decodedBytes = Base64.getDecoder().decode(uploadFileDTO.getFileBase64());

     
            blobClient.upload(new ByteArrayInputStream(decodedBytes), decodedBytes.length, true);



            resultService = "OK";
        } catch (Exception e) {
            resultService = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        return resultService;
    }

	@Override
	public String downloadFileAzure(UploadFileDTO uploadFileDTO) {
		String resultService = "";
        String storageConnectionAzure = blobstorageconnection;
        String nameContainer = "contenedor1";
        String userHome = System.getProperty("user.home");
        String downloadFolderPath = userHome + File.separator + "Downloads"; // Directorio de Descargas
        String downloadFilePath = downloadFolderPath + File.separator + uploadFileDTO.getName();

        try {
      
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(storageConnectionAzure)
                    .buildClient();

  
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(nameContainer);
            
            BlobClient blobClient = containerClient.getBlobClient(uploadFileDTO.getName());

            File file = new File(downloadFilePath);
            if (file.exists()) {
                Files.delete(Paths.get(downloadFilePath));
                resultService = "Archivo existente eliminado.";
            }

            blobClient.downloadToFile(downloadFilePath);
            resultService = "Archivo descargado exitosamente en: ";
        } catch (Exception e) {
            resultService = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        return resultService;
	}

	@Override
	public String deleteFileAzure(UploadFileDTO uploadFileDTO) {

		String resultService = "";
        String storageConnectionAzure = blobstorageconnection;
        String nameContainer = "contenedor1";

        try {
      
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .connectionString(storageConnectionAzure)
                    .buildClient();

  
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(nameContainer);
            
            BlobClient blobClient = containerClient.getBlobClient(uploadFileDTO.getName());

            if (blobClient.exists()) {
                blobClient.delete();
                resultService = "Archivo eliminado exitosamente";
            } else {
                resultService = "Archivo no encontrado";
            }
            
        } catch (Exception e) {
            resultService = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        return resultService;
		
	}
}

