package com.antra.phonepad.combination.controller;

import com.antra.phonepad.combination.service.NumberConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    NumberConverterService numberConverterServiceImpl;
    @RequestMapping("/number")
    public List<String> phone(@RequestParam(value = "PhoneNumber") String number) {
        List<String> result = numberConverterServiceImpl.numberConverter(number);
        return result;
    }
}
