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

    private final Expression increase = (n) -> n + 1;
    private final Expression decrease = (n) -> n - 1;

    @Override
    public int increment() {
        return calculate(increase);
    }

    @Override
    public int decrement() {
        return calculate(decrease);
    }

    @Override
    public void setValue(int value) {
        repository.write(jedis, KEY, String.valueOf(value));
    }

    private int calculate(Expression expression) {
        String value = repository.read(jedis, KEY);
        if (value == null) {
            value = "0";
        }
        int number = Integer.valueOf(value);
        number = expression.calculate(number);
        repository.write(jedis, KEY, String.valueOf(number));
        return number;
    }

}
