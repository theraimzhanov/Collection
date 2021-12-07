package com.company.queve;

import com.company.arraylist.car.Car;
import com.company.collection.CarCollection;

public interface CarQueve extends CarCollection {
 boolean add(Car car);
 Car peek();
 Car poll();
}
