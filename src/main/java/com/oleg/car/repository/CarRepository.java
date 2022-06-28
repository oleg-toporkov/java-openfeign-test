package com.oleg.car.repository;

import com.oleg.car.entity.CarEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private final List<CarEntity> cars = new ArrayList<>(List.of(
            new CarEntity(1, "BMW", "3 Series", "Red"),
            new CarEntity(2, "Audi", "A4", "Grey"),
            new CarEntity(3, "Mercedes", "CLA", "Blue"),
            new CarEntity(4, "Volkswagen", "Passat", "Green"),
            new CarEntity(5, "", "", "")
    ));

    public List<CarEntity> getAllCars() {
        return cars;
    }

    public CarEntity getCarById(Integer id) {
        return cars.stream().filter(carEntity -> carEntity.getId().equals(id)).findAny().orElseThrow();
    }

    public CarEntity save(CarEntity car) {
        int id = cars.size() + 1;
        car.setId(id);

        cars.add(car);
        return car;
    }
}