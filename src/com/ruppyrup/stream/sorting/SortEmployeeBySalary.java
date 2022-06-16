package com.ruppyrup.stream.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortEmployeeBySalary {

  static List<Employee> employees = Arrays.asList(
      new Employee(1, 5000),
      new Employee(2, 1000),
      new Employee(3, 600),
      new Employee(4, 55000),
      new Employee(5, 25000)
  );

  public static void main(String[] args) {
    List<Employee> employees1 = employees.stream()
        .sorted(Comparator.comparing(e -> e.salary))
        .toList();

    System.out.println(employees1);

    // Get third largest salary

    Employee employee = employees.stream()
        .sorted(Comparator.comparing(e -> e.salary))
        .skip(3)
        .findFirst()
        .orElseThrow();

    System.out.println(employee);

  }


  static class Employee {
    int id;
    int salary;

    public Employee(int id, int salary) {
      this.id = id;
      this.salary = salary;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "id=" + id +
          ", salary=" + salary +
          '}';
    }
  }

}
