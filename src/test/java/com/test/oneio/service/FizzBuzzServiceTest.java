package com.test.oneio.service;

import com.test.oneio.Exception.GameException;
import com.test.oneio.model.FizzBuzzGameResponseModel;
import com.test.oneio.service.Impl.FizzBuzzService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

/*
 * FizzBuzzServiceTest is the test class for FizzBuzzService and the game logic. 
 */
public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService;

    @BeforeEach
    public void setUp() {
        fizzBuzzService = new FizzBuzzService(10000000);
    }

    @Test
    void testFizzBuzzServiceWithNoSize() {
        FizzBuzzGameResponseModel res = fizzBuzzService.playGame(1,0);
        assert res.getItems().size() == 1;
        assert res.getItems().get(0).equals("1");
    }

    @Test
    void testFizzBuzzServiceWithSize1() {
        FizzBuzzGameResponseModel res = fizzBuzzService.playGame(1,1);
        assert res.getItems().size() == 2;
        assert res.getItems().equals(Arrays.asList( "1", "2"));
    }

    @Test
    void testFizzBuzzServiceWithSize4() {
        FizzBuzzGameResponseModel res = fizzBuzzService.playGame(1,4);
        assert res.getItems().size() == 5;
        assert res.getItems().equals(Arrays.asList( "1", "2", "Fizz", "4", "Buzz"));
    }

    @Test
    void testFizzBuzzServiceWithStartOtherThan1() {
        FizzBuzzGameResponseModel res = fizzBuzzService.playGame(3,12);
        assert res.getItems().size() == 13;
        assert res.getItems().equals(Arrays.asList( "Fizz", "4", "Buzz", 
            "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"));
    }

    @Test
    void testFizzBuzzServiceForLargeSize() {
        FizzBuzzGameResponseModel res = fizzBuzzService.playGame(1,1000000);
        assert res.getItems().size() == 1000001;
    }

    /*
     * Service layer should throw exception if start value is less than 1. 
     */
    @Test
    void testFizzBuzzServiceThrowsException() {
        GameException thrown = assertThrows(GameException.class, () -> {
            fizzBuzzService.playGame(0,0);
        });
        assertTrue(thrown.getMessage().equalsIgnoreCase("Invalid input value!"));
    }

    /*
     * Service throws exception when start value is greater than Integer.MAX_VALUE 
     */
    @Test
    void testFizzBuzzServiceThrowsException2() {
        GameException thrown = assertThrows(GameException.class, () -> {
            fizzBuzzService.playGame(Integer.MAX_VALUE+1,0);
        });
        assertTrue(thrown.getMessage().equalsIgnoreCase("Invalid input value!"));
    }
}
