package com.test.oneio.service;

import com.test.oneio.Exception.GameException;
import com.test.oneio.model.FizzBuzzGameResponseModel;

/*
 * FizzBuzzInterface defines the playGame method for FizzBuzz game.
 */
public interface FizzBuzzInterface {
    FizzBuzzGameResponseModel playGame(int start, int size) throws GameException;
}
