package com.company.arraylist.car;

import com.company.arraylist.car.Car;
import com.company.collection.CarCollection;

public interface CarList extends CarCollection {
  Car get(int index);
  boolean add(Car car,int index);
  boolean add(Car car);
  boolean remove(Car car);
  boolean removeAt(int index);
  int size();
  void clear();
}
