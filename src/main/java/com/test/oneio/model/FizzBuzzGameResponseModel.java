package com.test.oneio.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * FizzBuzzGameResponseModel is the response model class for FizzBuzz game, 
 * holding the response list of strings.
 */
@Data
@AllArgsConstructor
public class FizzBuzzGameResponseModel {
    List<String> items;
}
