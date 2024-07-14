package com.armancodeblock.carShowRoom.carController;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private final CarService carService;

    public Controller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars=carService.getAllCars();
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @GetMapping("/{make}")
    public ResponseEntity<List<Car>> getCarsByMake(@PathVariable String make){
        List<Car> carList=carService.findCarsByMake(make);
        return new ResponseEntity<>(carList,HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Void> createCar(@RequestBody Car car){
//        carService.create(car);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @PostMapping("/create")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car savedCar= carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Car> removeCarById(@PathVariable Long id){
        Car deleteCar=carService.deleteCar(id);
        return ResponseEntity.ok(deleteCar);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Long id, @RequestBody Car car){
        carService.carUpdate(id,car);
        return ResponseEntity.noContent().build();
    }
}
