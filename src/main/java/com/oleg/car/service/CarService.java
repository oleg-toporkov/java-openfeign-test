package com.oleg.car.service;

import com.oleg.car.entity.CarEntity;
import com.oleg.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarEntity getCarById(Integer id) {
        return carRepository.getCarById(id);
    }

    public List<CarEntity> getAllCars() {
        return carRepository.getAllCars();
    }

    public CarEntity saveCar(CarEntity car) {
        return carRepository.save(car);
    }
}