package com.oleg.car.controller;

import com.oleg.car.api.ICarApi;
import com.oleg.car.entity.CarEntity;
import com.oleg.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController implements ICarApi {

    private final CarService carService;

    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    public CarEntity getCarById(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    public CarEntity saveCar(@RequestBody CarEntity car) {
        return carService.saveCar(car);
     }
}