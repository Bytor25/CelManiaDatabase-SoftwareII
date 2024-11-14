package co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogService {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public String getMessage(String key) {
		
		return redisTemplate.opsForValue().get(key);
		
	}

}
