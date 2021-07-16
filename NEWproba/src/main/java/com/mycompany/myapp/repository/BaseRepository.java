package com.mycompany.myapp.repository;

import redis.clients.jedis.Jedis;

public interface BaseRepository {
    String read(Jedis jedis, String key);
    void write(Jedis jedis, String key, String value);
}
