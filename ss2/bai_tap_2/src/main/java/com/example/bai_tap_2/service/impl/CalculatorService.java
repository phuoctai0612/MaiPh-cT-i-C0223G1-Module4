package com.example.bai_tap_2.service.impl;

import com.example.bai_tap_2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(String calculation, Double param1, Double param2) {
        String error = "Không đúng định dạng";
        String result = null;
        if (param1 == null || param2 == null) {
            return error;
        }

        switch (calculation) {
            case "":
                return "Bạn phải chọn phép tính";
            case "+":
                result = String.valueOf(param1 + param2);
                break;
            case "-":
                result = String.valueOf(param1 - param2);
                break;
            case "*":
                result = String.valueOf(param1 * param2);
                break;
            case "/":
                if (param2 == 0) {
                    return "Không được chia cho 0";
                }
                result = String.valueOf(param1 / param2);
                break;
        }
        return result;
    }
}
