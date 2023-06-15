package com.example.thuc_hanh_2.service.impl;

import com.example.thuc_hanh_2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String getMoney(Double usd, Double tiGia) {
        String tienTe = String.valueOf(usd * tiGia);
        if (usd * tiGia < 0) {
            return "Sai định dạng tiền tệ";
        }
        return tienTe;
    }
}
