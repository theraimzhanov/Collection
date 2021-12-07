package com.company.arraylist.car;

import com.company.arraylist.car.Car;
import com.company.arraylist.car.CarList;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList implements CarList {

    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean add(Car car) {
       increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0;i< array.length;i++){
            if (array[i].equals(car)){
                return removeAt(i);
            }
        }
        return false;
    }
    @Override
    public boolean contains(Car car) {
        for (int i = 0;i< array.length;i++){
            if (array[i].equals(car)|| array[i] != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index;i<size-1;i++){
            array[i] = array[i+1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
          size = 0;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int index = 0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public Car next() {
             return  array[index++];

            }
        };
    }

    @Override
    public boolean add(Car car, int index) {
        increaseArray();
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
        return true;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public void increaseArray(){
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
