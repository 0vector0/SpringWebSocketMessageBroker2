package com.mykhalechko;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class CalculatorController {

    @MessageMapping("/addNum")
    public String addNumbers(String input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CalculatorInput data = mapper.readValue(input, CalculatorInput.class);
        CalculatorResult result = new CalculatorResult();
        result.setResult("" + (data.getNum1() + data.getNum2()));
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}