package com.test.oneio.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.oneio.service.Impl.FizzBuzzService;

@RestController
@RequestMapping("/games")
@Slf4j
public class FizzBuzzController {

	@Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/v1/fizzbuzz")
    public ResponseEntity<?> playFizzBuzzGame(@RequestParam int start, @RequestParam int end) {
        log.info("Fizzbuzz game start!");
        log.debug("start: {}, end: {}", start, end);
        return ResponseEntity.ok(fizzBuzzService.playGame(start, end));
    }
}
