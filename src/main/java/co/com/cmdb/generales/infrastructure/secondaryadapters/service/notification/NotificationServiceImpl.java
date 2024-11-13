package co.com.cmdb.generales.infrastructure.secondaryadapters.service.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

import co.com.cmdb.generales.application.secondaryports.service.notification.NotificationService;
import co.com.cmdb.generales.application.secondaryports.vo.Email;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	private final AmazonSNSClient snsClient;

    @Value("${aws.sns.topic.arn}")
    private String topicArn;
    
    public NotificationServiceImpl(final AmazonSNSClient snsClient) {
    	
    	this.snsClient = snsClient;
    	
    }

	@Override
	public void send(Email email) {
		
		String message = email.getMessage();
		PublishRequest publishRequest = new PublishRequest(topicArn, message);
        snsClient.publish(publishRequest);
   
	}

	

}

