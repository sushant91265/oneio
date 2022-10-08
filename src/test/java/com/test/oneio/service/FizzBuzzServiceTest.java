package com.test.oneio.service;

import com.test.oneio.service.Impl.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void testFizzBuzzService2() {
        List<String> res = fizzBuzzService.playGame(1,3);
        assert res.size() == 3;
        assert res.equals(Arrays.asList( "1", "2", "Fizz"));
    }

    @Test
    void testFizzBuzzService3() {
        List<String> res = fizzBuzzService.playGame(1,5);
        assert res.size() == 5;
        assert res.equals(Arrays.asList( "1", "2", "Fizz", "4", "Buzz"));
    }

    @Test
    void testFizzBuzzService4() {
        List<String> res = fizzBuzzService.playGame(1,15);
        assert res.size() == 15;
        assert res.equals(Arrays.asList( "1", "2", "Fizz", "4", "Buzz", 
            "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"));
    }

}
