package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {
    @Autowired
    private final CarRepository carRepository;

    public CarImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findCarsByMake(String make) {
        return carRepository.findCarByMake(make);
    }

}
