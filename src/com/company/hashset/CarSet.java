package com.company.hashset;

import com.company.arraylist.car.Car;
import com.company.collection.CarCollection;

public interface CarSet extends CarCollection {
   boolean add(Car car);
   boolean remove(Car car);
   int size();
   void clear();
}
