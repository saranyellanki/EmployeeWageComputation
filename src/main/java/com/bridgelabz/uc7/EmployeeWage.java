package com.bridgelabz.uc7;

import java.util.ArrayList;
import java.util.Scanner;

interface EmpWageBuilder{
    void empWageBuilder();
}

public class EmployeeWage implements EmpWageBuilder {
    final int FULL_TIME = 1;
    final int PART_TIME = 2;
    int wagePerHour;
    int workingDaysInMonth;
    int maxHoursInMonth;
    String companyName;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setWagePerHour(int wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public void setWorkingDaysInMonth(int workingDaysInMonth) {
        this.workingDaysInMonth = workingDaysInMonth;
    }

    public void setMaxHoursInMonth(int maxHoursInMonth) {
        this.maxHoursInMonth = maxHoursInMonth;
    }

    public void setValues() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Company Name : ");
        setCompanyName(sc.nextLine());
        System.out.println("Enter wage per hour : ");
        setWagePerHour(sc.nextInt());
        System.out.println("Enter working days in a month : ");
        setWorkingDaysInMonth(sc.nextInt());
        System.out.println("Enter maximum hours in a month : ");
        setMaxHoursInMonth(sc.nextInt());
    }
    public void computeEmployeeWage() {
        int empHrs = 0;
        int empWage = 0;
        int totalEmpWage = 0;
        int employeeWorkingHrs = 0;

        for (int day = 0; day < workingDaysInMonth && employeeWorkingHrs < maxHoursInMonth; day++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            if (empCheck == FULL_TIME)
                empHrs = 8;
            else if (empCheck == PART_TIME)
                empHrs = 4;
            else
                empHrs = 0;

            empWage = empHrs * wagePerHour;
            totalEmpWage += empWage;
            employeeWorkingHrs += empHrs;
            System.out.println("Number of Days : " + day + " & Number of Working hours :" + employeeWorkingHrs);
            System.out.println("Employee Wage : " + empWage);
        }
        System.out.println("Total Wage of Employee in " + companyName + " is : " + totalEmpWage);
    }
    public void empWageBuilder() {
        ArrayList<Object> empWageArray = new ArrayList<>();
        EmployeeWage company1 = new EmployeeWage();
        EmployeeWage company2 = new EmployeeWage();
        company1.setValues();
        String nameOfCompany1 = company1.companyName;
        company2.setValues();
        String nameOfCompany2 = company2.companyName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter company name to fetch total wage : ");
        String nameCompany = sc.nextLine();
        if(nameOfCompany1.equalsIgnoreCase(nameCompany)){
            company1.computeEmployeeWage();
        }
        else if(nameOfCompany2.equalsIgnoreCase(nameCompany)){
            company2.computeEmployeeWage();
        }
        empWageArray.add(company1);
        empWageArray.add(company2);
    }
    public static void main(String[] args) {
        EmpWageBuilder empWageObj = new EmployeeWage();
        empWageObj.empWageBuilder();
    }
}