package com.oleg.car.api;

import com.oleg.car.entity.CarEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "car-service", url = "${car-service.url}")
public interface ICarApi {

    @GetMapping("/cars")
    List<CarEntity> getAllCars();

    @GetMapping("/cars/{id}")
    CarEntity getCarById(@PathVariable Integer id);

    @PostMapping("/cars")
    CarEntity saveCar(@RequestBody CarEntity car);

}