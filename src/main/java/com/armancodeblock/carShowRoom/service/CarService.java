package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    List<Car> findCarsByMake(String make);

}
