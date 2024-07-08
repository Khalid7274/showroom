package com.armancodeblock.carShowRoom.repo;

import com.armancodeblock.carShowRoom.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
List<Car> findCarByMake(String make);
//List<Car> findCarByModel(String model);
//List<Car> findCarsByMakeAndModel(String make, String model);

}
