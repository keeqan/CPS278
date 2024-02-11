package com.college.collegedemo;

public class CommunityCollegeService implements CollegeService {

    public String getService(String collegeName) {
        return collegeName + " is a 2 year community college.";
    }
    
}
