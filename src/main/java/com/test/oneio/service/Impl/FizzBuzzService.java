package com.test.oneio.service.Impl;

import com.test.oneio.Exception.GameException;
import com.test.oneio.model.FizzBuzzGameModel;
import com.test.oneio.model.FizzBuzzGameResponseEnum;
import com.test.oneio.model.FizzBuzzGameResponseModel;
import com.test.oneio.service.FizzBuzzInterface;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * FizzBuzzService is the service class for FizzBuzz game, where actual game 
 * logic is implemented. It also leverages the pagination logic.
 */
@Service
@Slf4j
public class FizzBuzzService implements FizzBuzzInterface
{   
    @Value("${fizzbuzz.max.value}")
    private int maxFizzBuzzValue;

    @Override
    public FizzBuzzGameResponseModel playGame(final int start, final int size) throws GameException {
        if (start < 1 || size < 0 || start + size > maxFizzBuzzValue) {
            throw new GameException("Invalid input value!");
        }
        log.info("Processing fizzbuzz game with start: " + start + ", size: " + size);
        List<String> response = IntStream.rangeClosed(start, start+size)
                .mapToObj(this::fizzBuzzGame)
                .collect(Collectors.toList());
        
        return new FizzBuzzGameResponseModel(response);
    }

        
    private String fizzBuzzGame(final int num) {

        boolean fizzDivisible = num % FizzBuzzGameModel.FIZZ_NUMBER == 0;
        boolean buzzDivisible = num % FizzBuzzGameModel.BUZZ_NUMBER == 0;

        if(fizzDivisible && buzzDivisible) {
            return FizzBuzzGameResponseEnum.FizzBuzz.name();
        } else if(fizzDivisible) {
            return FizzBuzzGameResponseEnum.Fizz.name();
        } else if(buzzDivisible) {
            return FizzBuzzGameResponseEnum.Buzz.name();
        } else {
            return String.valueOf(num);
        }
    }
}
