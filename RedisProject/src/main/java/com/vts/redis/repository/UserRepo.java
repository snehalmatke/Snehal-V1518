package com.vts.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vts.redis.model.User;

@Repository
public class UserRepo {

	@Autowired
	private RedisTemplate redisTemplate;

	public static final String HASH_KEY = "User";

	public User save(User user) {
		redisTemplate.opsForHash().put(HASH_KEY, user.getId(), user);
		return user;
	}

	public List<User> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}

	public User getById(int id) {
		return (User) redisTemplate.opsForHash().get(HASH_KEY, id);
		
	}

	public String deleteById(int id) {
		redisTemplate.opsForHash().delete( HASH_KEY, id);
		return " delete successfully";
	}

	public User updateById(int id,User user) {
		User obj = (User) redisTemplate.opsForHash().get(HASH_KEY, user);
		return obj;
	}
	
}
