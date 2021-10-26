package com.bridgelabz.uc7;

import java.util.Scanner;

public class EmployeeWage {
    int fullTime;
    int partTime;
    int wagePerHour;
    int workingDaysInMonth;
    int maxHoursInMonth;
    public void setFullTime(int fullTime){
        this.fullTime = fullTime;
    }
    public void setPartTime(int partTime){
        this.partTime = partTime;
    }
    public void setWagePerHour(int wagePerHour){
        this.wagePerHour = wagePerHour;
    }
    public void setWorkingDaysInMonth(int workingDaysInMonth){
        this.workingDaysInMonth = workingDaysInMonth;
    }
    public void setMaxHoursInMonth(int maxHoursInMonth){
        this.maxHoursInMonth = maxHoursInMonth;
    }
    public void setValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full time hours : "+fullTime);
        setFullTime(sc.nextInt());
        System.out.println("Enter part time hours : "+partTime);
        setPartTime(sc.nextInt());
        System.out.println("Enter wage per hour : "+wagePerHour);
        setWagePerHour(sc.nextInt());
        System.out.println("Enter working days in a month : "+workingDaysInMonth);
        setWorkingDaysInMonth(sc.nextInt());
        System.out.println("Enter maximum hours in a month : "+maxHoursInMonth);
        setMaxHoursInMonth(sc.nextInt());
    }
    public void computeEmployeeWage(){
        int empHrs = 0;
        int empWage = 0;
        int totalEmpWage = 0;
        int employeeWorkingHrs = 0;

        for ( int day = 0; day < workingDaysInMonth && employeeWorkingHrs < maxHoursInMonth; day++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            if (empCheck == fullTime)
                empHrs = 8;
            else if (empCheck == partTime)
                empHrs = 4;
            else
                empHrs = 0;

            empWage = empHrs * wagePerHour;
            totalEmpWage += empWage;
            employeeWorkingHrs += empHrs;
            System.out.println("Number of Days : " + day + " & Number of Working hours :" + employeeWorkingHrs);
            System.out.println("Employee Wage : " + empWage);
        }
        System.out.println("Total Wage : " + totalEmpWage);
    }
    public static void main(String[] args){
        EmployeeWage employeeWageObj = new EmployeeWage();
        employeeWageObj.setValues();
        employeeWageObj.computeEmployeeWage();
    }
}
