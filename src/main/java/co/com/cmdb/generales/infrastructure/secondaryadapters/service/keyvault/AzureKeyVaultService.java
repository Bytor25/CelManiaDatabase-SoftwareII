package co.com.cmdb.generales.infrastructure.secondaryadapters.service.keyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

import co.com.cmdb.generales.application.secondaryports.service.keyvault.VaultService;

@Component
public class AzureKeyVaultService implements VaultService {

    private final SecretClient secretClient;

    public AzureKeyVaultService(@Value("${azure.keyvault.url}") String urlVault){
    	
        this.secretClient = new SecretClientBuilder().vaultUrl(urlVault)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }
    
    @Override
    public String getSecretValue(String secretName) {
    	
    	return secretClient.getSecret(secretName).getValue();
    	
    }
    
}
