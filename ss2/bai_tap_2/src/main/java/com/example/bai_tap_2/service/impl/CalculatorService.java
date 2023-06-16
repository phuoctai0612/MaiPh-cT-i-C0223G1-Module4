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
        if (calculation.equals("")) {
            return "Bạn phải chọn phép tính";
        } else if (calculation.equals("+")) {
            result = String.valueOf(param1 + param2);
        } else if (calculation.equals("-")) {
            result = String.valueOf(param1 - param2);
        } else if (calculation.equals("*")) {
            result = String.valueOf(param1 * param2);
        } else if (calculation.equals("/")) {
            if (param2 == 0) {
                return "Không được chia cho 0";
            }
            result = String.valueOf(param1 / param2);
        }
        return result;
    }
}
