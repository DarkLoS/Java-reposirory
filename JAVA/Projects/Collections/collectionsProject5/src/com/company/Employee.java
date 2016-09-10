package com.company;
public class Employee
{
    private String name;
    private double salary;
    public Employee(String n)
    {
        name = n;
        salary = 0;
    }
    public String toString()
    {
        return "[name=" + name + ", salary=" + salary + "]";
    }
}