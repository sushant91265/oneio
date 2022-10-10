package com.test.oneio.service.Impl;

import com.test.oneio.Exception.GameException;
import com.test.oneio.model.FizzBuzzGameModel;
import com.test.oneio.model.FizzBuzzGameResponseEnum;
import com.test.oneio.model.FizzBuzzGameResponseModel;
import com.test.oneio.service.FizzBuzzInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/*
 * FizzBuzzService is the service class for FizzBuzz game, where actual game 
 * logic is implemented. It also leverages the pagination logic.
 */
@Service
public class FizzBuzzService implements FizzBuzzInterface
{       
    @Override
    public FizzBuzzGameResponseModel playGame(final int start, final int size) throws GameException {
        if (start < 1 || start > Integer.MAX_VALUE || size < 0 || size > Integer.MAX_VALUE) {
            throw new GameException("Invalid input value!");
        }
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
