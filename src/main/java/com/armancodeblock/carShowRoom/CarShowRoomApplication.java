package com.armancodeblock.carShowRoom;

import com.armancodeblock.carShowRoom.entity.Car;
import com.armancodeblock.carShowRoom.repo.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarShowRoomApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CarShowRoomApplication.class);
	private final CarRepository carRepository;

	@Autowired
	public CarShowRoomApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarShowRoomApplication.class, args);
		logger.info("Showroom Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		List<Car> carList = Arrays.asList(
				new Car("Tesla", "Y", "Silver", "334411", 2025, 58000.0),
				new Car("Toyota", "Camry", "Red", "99875", 2024, 90000.0),
				new Car("Toyota", "Corolla", "White", "34355", 2020, 80000.0),
				new Car("Honda", "Ceto", "Black", "34355", 2018, 10000.0)
		);
		carRepository.saveAll(carList);

		for (Car car : carRepository.findAll()) {
			logger.info(car.getMake() + " " + car.getModel());
		}
	}
}