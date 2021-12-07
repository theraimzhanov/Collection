package com.company.arraylist.car;

import java.util.Objects;

public class Car {
  private String brand;
  private int number;

  public Car(String brand, int number) {
    this.brand = brand;
    this.number = number;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return number == car.number && Objects.equals(brand, car.brand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, number);
  }

 /* @Override
  public int compareTo(Car o) {
  return brand.compareTo(o.brand);
  }*/

  @Override
  public String toString() {
    return "Car{" +
            "brand='" + brand + '\'' +
            ", number=" + number +
            '}';
  }
}
