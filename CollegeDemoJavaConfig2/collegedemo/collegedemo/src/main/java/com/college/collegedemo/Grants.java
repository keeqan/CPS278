package com.college.collegedemo;

import org.springframework.stereotype.Component;

@Component
public class Grants implements FinaidService{
    public String getFinaidType(){
        return "Grants"; 
    }
    
}
