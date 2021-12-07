package com.company.arraylist.employee;

import java.util.Arrays;

public class EmployeeArrayList implements EmployeeList {
  private Employee[] array = new Employee[10];
  private int size = 0;
    @Override
    public void clear() {
      size = 0;
      array = new Employee[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Employee employee) {
increaseArrayList();
array[size] = employee;
size++;
    }

    @Override
    public Employee get(int index) {
       checkIndex(index);
      return array[index];
    }

    @Override
    public boolean remove(Employee employee) {
      for (int i = 0;i< array.length;i++){
        if (array[i].equals(employee)){
          removeIndex(i);
        }
      }
        return false;
    }

    @Override
    public boolean removeIndex(int index) {
       checkIndex(index);
      if (size - 1 - index >= 0)
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
       size--;
        return true;
    }

    @Override
    public void add(Employee employee, int index) {
 increaseArrayList();
 checkIndex(index);
 System.arraycopy(array,index,array,index+1,size - index);
 array[index] = employee;
 size++;
    }
    public void increaseArrayList(){
      if (size <= array.length){
        array = Arrays.copyOf(array,array.length*2);
      }
    }

    public void checkIndex(int index){
      if (index<0 || index>=size){
        throw new IndexOutOfBoundsException();
      }
    }
}
