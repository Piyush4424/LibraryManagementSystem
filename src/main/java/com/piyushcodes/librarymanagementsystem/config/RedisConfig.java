//package com.piyushcodes.librarymanagementsystem.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//public class RedisConfig {
//	
//	@Bean
//	public LettuceConnectionFactory getConnectionFactory()
//	{
//		RedisStandaloneConfiguration redisStandaloneConfiguration = 
//				new RedisStandaloneConfiguration("127.0.0.1",6379);
//		
//		LettuceConnectionFactory lettuceConnectionFactory = 
//				new LettuceConnectionFactory(redisStandaloneConfiguration);
//		return lettuceConnectionFactory;
//	}
//	
//	@Bean
//	public RedisTemplate<String, Object> getTemplate()
//	{
//		RedisTemplate<String, Object> redisTemplate = 
//				new RedisTemplate<String, Object>();
//		redisTemplate.setConnectionFactory(getConnectionFactory());
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//		return redisTemplate;
//	}
//	
//	@Bean
//	public ObjectMapper getMapper()
//	{
//		return new ObjectMapper();
//	}
//}
