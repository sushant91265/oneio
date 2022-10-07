package com.test.oneio.service.Impl;

import com.test.oneio.model.FizzBuzzGameModel;
import com.test.oneio.model.FizzBuzzGameResponseModel;
import com.test.oneio.service.FizzBuzzInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService implements FizzBuzzInterface
{   
    @Override
    public List<String> playGame(int n) throws RuntimeException {
        // TODO: list is bottleneck for parallelism? 
        // [https://stackoverflow.com/questions/68911336/size-of-arraylist-modified-by-parallel-stream]
        // TODO: what is the max value of n?
        if(n > Integer.MAX_VALUE || n <  Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Input is out of range!");
        }
        return IntStream.rangeClosed(1, n)
                .parallel()
                .mapToObj(this::fizzBuzzGame)
                .collect(Collectors.toList());
    }

    private String fizzBuzzGame(int num) {
        FizzBuzzGameModel model = new FizzBuzzGameModel();

        boolean fizzDivisible = num % model.getFIZZ_NUMBER() == 0;
        boolean buzzDivisible = num % model.getBUZZ_NUMBER() == 0;

        FizzBuzzGameResponseModel responseModel = new FizzBuzzGameResponseModel();

        if(fizzDivisible && buzzDivisible) {
            return responseModel.getFizzBuzz();
        } else if(fizzDivisible) {
            return responseModel.getFizz();
        } else if(buzzDivisible) {
            return responseModel.getBuzz();
        } else {
            return String.valueOf(num);
        }
    }
}
