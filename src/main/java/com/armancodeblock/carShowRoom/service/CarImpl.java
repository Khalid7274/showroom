package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.repo.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car deleteCar(Long id) {
        Optional<Car> carOptional= carRepository.findById(id);
        if(carOptional.isPresent()){
            Car car=carOptional.get();
            carRepository.deleteById(id);
            return car;
        }else {
            throw new EntityNotFoundException("Car not found with Id: "+id);
        }
    }

    @Override
    public Void carUpdate(Long id, Car car) {
        Optional<Car> existingCarOptional = carRepository.findById(id);
        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setMake(car.getMake());
            existingCar.setModel(car.getModel());
            existingCar.setColor(car.getColor());
            existingCar.setRegistrationNumber(car.getRegistrationNumber());
            existingCar.setYear(car.getYear());
            existingCar.setPrice(car.getPrice());
            existingCar.setOwner(car.getOwner());
            carRepository.save(existingCar);
        } else {
            throw new EntityNotFoundException("Car not found with id: " + id);
        }
        return null;
    }


//    @Override
//    public Void create(Car car) {
//        carRepository.save(car);
//        return null;
//    }


}
