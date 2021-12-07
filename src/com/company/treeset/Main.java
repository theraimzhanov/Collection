package com.company.treeset;


import com.company.arraylist.car.Car;
import com.company.arraylist.car.CarArrayList;
import com.company.arraylist.car.CarList;
import com.company.arraylist.car.CustomerList;
import com.company.collection.CarCollection;
import com.company.linkedlist.CarLinkedList;
import com.company.linkedlist.ListCar;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;


public class Main {
    public static void main(String[] args) {

      TreeSet<Car> cars = new TreeSet<>(new Comparator<Car>() {
          @Override
          public int compare(Car o1, Car o2) {
              return o1.getBrand().compareTo(o2.getBrand());
          }
      });
      for (int i=0;i<100;i++){
          cars.add(new Car("Brand: "+i,i));
      }
      for (Car car:cars){
          System.out.println(car);
      }
     }
}
