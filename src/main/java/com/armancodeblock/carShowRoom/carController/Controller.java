package com.armancodeblock.carShowRoom.carController;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
