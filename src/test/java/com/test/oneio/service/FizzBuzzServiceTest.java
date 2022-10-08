package com.test.oneio.service;

import com.test.oneio.service.Impl.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService;
    @BeforeEach
    public void setUp() {
        fizzBuzzService = new FizzBuzzService();
    }

    @Test
    void testFizzBuzzService() {
        List<String> res = fizzBuzzService.playGame(2,2);
        assert res.size() == 1;
        assert res.get(0).equals("2");
    }
}
