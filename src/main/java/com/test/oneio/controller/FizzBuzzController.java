package com.test.oneio.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.oneio.service.Impl.FizzBuzzService;

/*
 * Controller class for FizzBuzz exposing GET API [/games/v1/fizzbuzz?start=1&size=99]
 */
@RestController
@RequestMapping("/games")
@CrossOrigin
@Slf4j
public class FizzBuzzController {

	@Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/v1/fizzbuzz")
    public ResponseEntity<?> playFizzBuzzGame(
        @RequestParam(required = true) int start, @RequestParam(defaultValue = "0") int size) {
        log.info("Fizzbuzz game start!");
        log.debug("Start: " + start + ", size: " + size);
        return ResponseEntity.ok(fizzBuzzService.playGame(start, size));
    }
}
