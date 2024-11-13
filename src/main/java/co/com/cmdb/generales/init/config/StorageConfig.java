package co.com.cmdb.generales.init.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class StorageConfig {
	
	  @Value("${aws.accessKeyId}")
	  private String accessKey;

	  @Value("${aws.secretKey}")
	  private String secretKey;

	  @Value("${aws.region}")
	  private String region;
	  
	  @Bean
	  public AmazonS3 generateS3client() {
		  
		  AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		  return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();
		  
	  }
	 
}
