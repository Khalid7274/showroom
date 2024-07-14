package com.armancodeblock.carShowRoom.carController;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.entity.Owner;
import com.armancodeblock.carShowRoom.service.CarService;
import com.armancodeblock.carShowRoom.service.OwnerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class Controller {
    @Autowired
    private final CarService carService;
    private final OwnerService ownerService;

    public Controller(CarService carService, OwnerService ownerService) {
        this.carService = carService;
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{make}")
    public ResponseEntity<List<Car>> getCarsByMake(@PathVariable String make){
        List<Car> carList = carService.findCarsByMake(make);
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car savedCar = carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @PostMapping("/add/{Ownerid}")
    public ResponseEntity<Car> addCarWithOwner(@RequestBody Car car, @PathVariable Long Ownerid){
        Owner owner = ownerService.findOwnerById(Ownerid);
        car.setOwner(owner);
        Car savedCar = carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Car> removeCarById(@PathVariable Long id){
        Car deleteCar = carService.deleteCar(id);
        return ResponseEntity.ok(deleteCar);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            Car updatedCar = carService.carUpdate(id, car);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
