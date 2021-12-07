package com.company.map;

import java.util.Objects;

public class CarOwner {
private int id;
private String name;
private String last;

    public CarOwner(int id, String name, String last) {
        this.id = id;
        this.name = name;
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwner carOwner = (CarOwner) o;
        return id == carOwner.id && Objects.equals(name, carOwner.name) && Objects.equals(last, carOwner.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last);
    }
}
