package com.college.collegedemo;

public class University implements CollegeService {

    public String getService(String collegeName) {
        return collegeName + " is a 4 year community college.";
    }
    
}
