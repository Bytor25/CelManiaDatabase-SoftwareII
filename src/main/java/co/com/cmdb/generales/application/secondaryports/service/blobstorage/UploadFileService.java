package co.com.cmdb.generales.application.secondaryports.service.blobstorage;

import co.com.cmdb.generales.application.primaryports.dto.UploadFileDTO;

public interface UploadFileService {

	
	public String uploadFileAzure(UploadFileDTO uploadFileDTO); 
	public String downloadFileAzure(UploadFileDTO uploadFileDTO);
	public String deleteFileAzure(UploadFileDTO uploadFileDTO);

	
}
