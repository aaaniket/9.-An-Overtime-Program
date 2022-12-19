/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.overtime;

import java.util.Scanner;

/**
 *
 * @author merch
 */
public class CalculateOvertime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double[] hours_per_day = new double[5];
        double regular_hourly_wage_rate = 0.0;
        
        double total_hours_weekly = 0.0;
        
        try {
            // Getting hours_per_day
            System.out.println("Enter number of hours worked per day, individually for five days: ");
            for(int i=0; i<5; i++) {
                hours_per_day[i] = getDoubleInput(s);

                if (hours_per_day[i]<0 || hours_per_day[i]>24) {
                    System.out.println("Invalid number of hours entered : " + hours_per_day[i]);
                    
                    return;
                }
                
                total_hours_weekly += hours_per_day[i];
            }
            
            System.out.println("Enter regular hourly wage rate: ");
            regular_hourly_wage_rate = getDoubleInput(s);
            
            if(regular_hourly_wage_rate < 0) {
                System.out.println("Regular hourly wage rate cannot be negative...");
                
                return;
            }
            
            calculate(total_hours_weekly, regular_hourly_wage_rate);
        }
        catch(Exception e) {
            System.out.println("Exception occured while reading input...");
            System.out.println(e.getMessage());
        }
    }
    
    public static double getDoubleInput(Scanner s) throws Exception {
        String buffer = s.next();
        double res = 0;
        
        // checking validity of input
        if(!buffer.isEmpty()) {
            res = Double.parseDouble(buffer);
        }
        
        return res;
    }
    
    public static void calculate(double total_hours_weekly, double regular_hourly_wage_rate) {
        double total_pay = 0;
        
        if (total_hours_weekly > 40) {
            total_pay = 40 * regular_hourly_wage_rate + 
                        (total_hours_weekly - 40) * regular_hourly_wage_rate * 1.5;
        }
        else {
            total_pay = total_hours_weekly * regular_hourly_wage_rate;
        }
        
        double avg_pay_per_hour = total_pay / total_hours_weekly;
        
        System.out.println("Worker's total weekly pay: " + total_pay);
        System.out.println("Worker's average number of hours worked per day: " + total_hours_weekly/5.0);
        System.out.println(" Average pay per hour including overtime pay for the week is: " + avg_pay_per_hour);
    }
}