package com.college.collegedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("finaid2")
public class Finaid {
    @Autowired
    private College college;
    @Autowired
    private FinaidService finaidService; 


   /*  public Finaid() {

    }
    @Autowired
    public Finaid(College college, FinaidService finaidService){
        super();
        this.college = college;
        this.finaidService = finaidService; 
    }
    */
    public void displayFinaid(){
        System.out.println("You recieved " + finaidService.getFinaidType() + " from "+ college.getCollegeName());
    }


    
}
