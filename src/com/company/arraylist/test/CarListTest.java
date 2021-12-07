package com.company.arraylist.test;

import com.company.arraylist.car.Car;
import com.company.arraylist.car.CarList;
import com.company.linkedlist.CarLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before()
    public void setUp() throws Exception {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeBeDecreased() {
        assertEquals(100, carList.size());
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemoveThenSizeBeDecreased() {
        Car car = new Car("lexus", 11);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Nex", 13);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMust0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals(0, car.getNumber());
    }
    @Test
    public void insertIntiFirstPosition(){
        Car car = new Car("BMV",1);
        carList.add(car,0);
        Car carFromList= carList.get(0);
        assertEquals("BMV",carFromList.getBrand());
    }
    @Test
    public void insertIntiLastPosition(){
        Car car = new Car("BMV",1);
        carList.add(car,100);
        Car carFromList= carList.get(100);
        assertEquals("BMV",carFromList.getBrand());
    }
}