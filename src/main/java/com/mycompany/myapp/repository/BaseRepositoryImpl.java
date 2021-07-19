package com.mycompany.myapp.repository;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class BaseRepositoryImpl implements BaseRepository {

    public String read(Jedis jedis, String key) {
        return jedis.get(key);
    }

    public void write(Jedis jedis, String key, String value) {
        jedis.set(key, value);
    }
}
