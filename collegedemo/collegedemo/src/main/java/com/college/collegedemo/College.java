package com.college.collegedemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class College {

    private String collegeName;
    private int yearBuilt;
    private String zipCode;
    private int enrollment; 
	private CollegeService collegeService;

    public College() {
    }

    public College(String collegeName, int yearBuilt) {
        super();
        this.collegeName = collegeName;
        this.yearBuilt = yearBuilt; 
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
	public String getCollegeName() {
        return  collegeName;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

	public void setCollegeService(CollegeService collegeService){
		this.collegeService = collegeService; 
	}

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

	public void printCollegeService(){
		System.out.println(collegeService.getService(collegeName));
	}

    @Override
    public String toString() {
        return "College [collegeName=" + collegeName + ", yearBuilt=" + yearBuilt + ", zipCode=" + zipCode + ", enrollment=" + enrollment + "]";
    }
}