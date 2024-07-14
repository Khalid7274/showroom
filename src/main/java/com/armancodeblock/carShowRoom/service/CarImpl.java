package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.entity.Owner;
import com.armancodeblock.carShowRoom.repo.CarRepository;
import com.armancodeblock.carShowRoom.repo.OwnerRepository; // Ensure this import is added
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarImpl implements CarService {
    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository; // Ensure OwnerRepository is correctly injected

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
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            carRepository.deleteById(id);
            return car;
        } else {
            throw new EntityNotFoundException("Car not found with Id: " + id);
        }
    }

    @Override
    public Car carUpdate(Long id, Car car) {
        Optional<Car> existingCarOptional = carRepository.findById(id);
        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setMake(car.getMake());
            existingCar.setModel(car.getModel());
            existingCar.setColor(car.getColor());
            existingCar.setRegistrationNumber(car.getRegistrationNumber());
            existingCar.setYear(car.getYear());
            existingCar.setPrice(car.getPrice());

            // Save the owner if it is not already saved
            if (car.getOwner() != null) {
                Owner owner = ownerRepository.save(car.getOwner());
                existingCar.setOwner(owner);
            }

            return carRepository.save(existingCar);
        } else {
            throw new EntityNotFoundException("Car not found with id: " + id);
        }
    }


}
