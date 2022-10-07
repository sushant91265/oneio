package com.test.oneio.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.oneio.service.Impl.FizzBuzzService;

// timout , ratelimit?
@RestController
@RequestMapping("/games")
@Validated
public class FizzBuzzController {
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    @Autowired
	private FizzBuzzService fizzBuzzService;

    // TODO for large input this will be a problem?
    // TODO parameter validation exception handling
    @GetMapping("/v1/fizzbuzz/{n}")
    @ResponseBody
    public ResponseEntity<?> playFizzBuzzGame(@PathVariable 
                                    @Min(value = 1, message = "Input should be greater than 1") 
                                    @Max(value = Integer.MAX_VALUE, message = "Invalid input") Integer n) {
        logger.info("Fizzbuzz game start!");
        logger.debug("Fizzbuzz game started with n = " + n);
        // TODO output return in different format?
        return ResponseEntity.ok(fizzBuzzService.playGame(n));
    }
}
