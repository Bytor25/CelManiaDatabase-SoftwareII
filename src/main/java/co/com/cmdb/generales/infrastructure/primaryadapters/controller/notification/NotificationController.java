package co.com.cmdb.generales.infrastructure.primaryadapters.controller.notification;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final AmazonSNSClient snsClient;

    @Value("${aws.sns.topic.arn}")
    private String topicArn; // Inyecta el ARN del topic desde el properties

    public NotificationController(AmazonSNSClient snsClient) {
        this.snsClient = snsClient;
    }

    @GetMapping("/send-notification")
    public String sendNotification() {
        try {
            // Crea el mensaje que deseas enviar
            String message = "Este es un mensaje de prueba desde Spring Boot";
            PublishRequest publishRequest = new PublishRequest(topicArn, message);
            
            // Publica el mensaje en el tema SNS
            PublishResult publishResult = snsClient.publish(publishRequest);
            
            // Devuelve el ID del mensaje enviado para confirmación
            return "Mensaje enviado exitosamente. Message ID: " + publishResult.getMessageId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al enviar el mensaje: " + e.getMessage();
        }
    }
}
