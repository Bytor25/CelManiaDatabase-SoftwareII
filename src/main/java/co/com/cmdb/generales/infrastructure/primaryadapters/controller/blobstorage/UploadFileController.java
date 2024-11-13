package co.com.cmdb.generales.infrastructure.primaryadapters.controller.blobstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cmdb.generales.application.primaryports.dto.UploadFileDTO;
import co.com.cmdb.generales.application.secondaryports.service.blobstorage.UploadFileService;

@RestController
@RequestMapping("/blobstorage-azure")
public class UploadFileController {
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@PostMapping(path = "/upload-contenedor1")
	public ResponseEntity<String> uploadFileBlobStorage(@RequestBody UploadFileDTO UploadFileDTO ){
		String resultService = uploadFileService.uploadFileAzure(UploadFileDTO);
		return new ResponseEntity<String>(resultService, HttpStatus.OK);
	}
	
	@PostMapping(path = "/download-contenedor1")
	public ResponseEntity<String> downloadFileBlobStorage(@RequestBody UploadFileDTO UploadFileDTO ){
		String resultService = uploadFileService.downloadFileAzure(UploadFileDTO);
		return new ResponseEntity<String>(resultService, HttpStatus.OK);
	}
	
	@PostMapping(path = "/delete-contenedor1")
	public ResponseEntity<String> deleteFileBlobStorage(@RequestBody UploadFileDTO UploadFileDTO ){
		String resultService = uploadFileService.deleteFileAzure(UploadFileDTO);
		return new ResponseEntity<String>(resultService, HttpStatus.OK);
	}

}
