package com.company.queve;

import com.company.arraylist.car.Car;
import com.company.linkedlist.CarLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueveTest {
private CarQueve carQueve;
    @Before
    public void setUp() throws Exception {
        carQueve = new CarLinkedList();
        for(int i=0;i<10;i++){
            carQueve.add(new Car("brand"+i,i));
        }
    }

    @Test
    public void add() {
        assertEquals(10,carQueve.size());
    }

    @Test
    public void peek() {
Car car = carQueve.peek();
assertEquals("brand0",car.getBrand());
        assertEquals(10,carQueve.size());
    }

    @Test
    public void poll() {
        Car car = carQueve.poll();
        assertEquals("brand0",car.getBrand());
        assertEquals(9,carQueve.size());
    }
}