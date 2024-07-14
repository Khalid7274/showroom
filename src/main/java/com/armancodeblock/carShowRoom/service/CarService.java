package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    List<Car> findCarsByMake(String make);
    //Void create(Car car);
    Car addCar(Car car);
    Car deleteCar(Long id);
    Void carUpdate(Long id, Car car);

}
