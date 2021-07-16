package com.mycompany.myapp.service;

import com.mycompany.myapp.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class BaseServiceImpl implements BaseService {

    private final String KEY = "ID";

    @Autowired
    private Jedis jedis;

    @Autowired
    private BaseRepository repository;

    @Override
    public int increment() {
        String value = repository.read(jedis, KEY);
        if (value == null) {
            value = "0";
        }
        int number = Integer.valueOf(value);
        number++;
        repository.write(jedis, KEY, String.valueOf(number));
        return number;
    }

    @Override
    public int decrement() {
        String value = repository.read(jedis, KEY);
        if (value == null) {
            value = "0";
        }
        int number = Integer.valueOf(value);
        number--;
        repository.write(jedis, KEY, String.valueOf(number));
        return number;
    }
}
