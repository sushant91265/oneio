package com.test.oneio.service.Impl;

import com.test.oneio.model.FizzBuzzGameModel;
import com.test.oneio.model.FizzBuzzGameResponseEnum;
import com.test.oneio.service.FizzBuzzInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService implements FizzBuzzInterface
{   
    @Override
    public List<String> playGame(int start, int end) throws RuntimeException {
        if (start < 1 || end < 1 || start > end || end > Integer.MAX_VALUE || ((end - start) > 100)) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return IntStream.rangeClosed(start, end)
                .parallel()
                .mapToObj(this::fizzBuzzGame)
                .collect(Collectors.toList());
    }

    private String fizzBuzzGame(int num) {

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
