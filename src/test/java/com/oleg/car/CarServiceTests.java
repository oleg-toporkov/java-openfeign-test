package com.oleg.car;

import com.oleg.car.api.ICarApi;
import com.oleg.car.configuration.TestConfiguration;
import com.oleg.car.entity.CarEntity;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ContextConfiguration(classes = {TestConfiguration.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
class CarServiceTests {

    @Qualifier("com.oleg.car.api.ICarApi")
    @Autowired
    private ICarApi iCarApi;

    @Test
    void testFeignWorks() {
        log.info("[{}]", iCarApi.getAllCars());
    }

    @Test
    void getAllCarsTest() {
        List<CarEntity> cars = iCarApi.getAllCars();
        assertThat("Service returns more that 0 cars",
                cars, hasSize(greaterThan(0)));
    }

    @Test
    void getOneCar() {
        Integer carId = 1;

        CarEntity car = iCarApi.getCarById(carId);

        assertThat("Id is not empty", car.getId(), is(carId));
        assertThat("Make is BMW", car.getMake(), is("BMW"));
        assertThat("Model is defined", car.getModel(), not(emptyOrNullString()));
    }

    @Test
    void getNonExistingCar() {
        Integer nonExistingCarId = 0;

        FeignException.InternalServerError error =
                Assertions.assertThrows(FeignException.InternalServerError.class,
                        () -> iCarApi.getCarById(nonExistingCarId));
        log.info("[{}]", error.toString());

        assertThat("Internal server error thrown", error.getMessage(),
                containsString("Internal Server Error"));
    }

    @Test
    void saveACar() {
        CarEntity car = CarEntity.builder()
                .color("Pink")
                .make("Volkswagen")
                .model("Beetle")
                .build();

        CarEntity savedCar = iCarApi.saveCar(car);
        log.info("[{}]", savedCar);
        assertThat("Has an id defined", savedCar.getId(), is(greaterThan(0)));
    }

}