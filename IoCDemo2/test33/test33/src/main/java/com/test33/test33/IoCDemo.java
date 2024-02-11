package com.test33.test33;

public class IoCDemo {

    public static void main(String[] args) {
        IBird chichadee = new SeedsEater();
       System.out.println(chichadee.getEatingHabit());
        
    }
    
}
