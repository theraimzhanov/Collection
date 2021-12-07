package com.company.map;

import com.company.arraylist.car.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarMap map;

    @Before
    public void setUp() throws Exception {
     map = new CarHashMap();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "name" + index, "lastName" + index);
            Car car = new Car("Brand" + index, index);
            map.put(carOwner, car);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(10, map.size());
        CarOwner elementForDeleting = new CarOwner(5, "name5", "lastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }
    @Test
    public void countOfKeysMustBeEqualsToCountOfValues(){
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
        assertEquals(100,map.keySet().size());
        assertEquals(100,map.values().size());
    }
    @Test
    public  void methodGetMustReturnRightValue(){
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "lastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100,map.size());
        CarOwner carOwner = new CarOwner(50,"name50","lastName50");
        Car car = map.get(carOwner);
        String values = car.getBrand();
        assertEquals(values,car.getBrand());
    }
}