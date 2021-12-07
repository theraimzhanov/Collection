package com.company.arraylist.employee;

public interface EmployeeList {
  void clear();
  int size();
  void add(Employee employee);
  Employee get(int index);
  boolean remove(Employee employee);
  boolean removeIndex(int index);
  void add(Employee employee,int index);
}
