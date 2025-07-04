package com.example.sampleapi.service;

import com.example.sampleapi.model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public CarService() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        cars.add(new Car(idCounter.getAndIncrement(), "Toyota", "Camry", 2023, "Red", 2.5, "Gasoline", 25000.00, 4,
                "Automatic", 15000));
        cars.add(new Car(idCounter.getAndIncrement(), "Honda", "Civic", 2023, "Blue", 1.8, "Gasoline", 22000.00, 4,
                "Automatic", 12000));
        cars.add(new Car(idCounter.getAndIncrement(), "Ford", "Mustang", 2023, "Black", 5.0, "Gasoline", 45000.00, 2,
                "Manual", 8000));
        cars.add(new Car(idCounter.getAndIncrement(), "BMW", "X5", 2023, "White", 3.0, "Diesel", 65000.00, 5,
                "Automatic", 20000));
        cars.add(new Car(idCounter.getAndIncrement(), "Mercedes", "C-Class", 2023, "Silver", 2.0, "Gasoline", 42000.00,
                4, "Automatic", 18000));
        cars.add(new Car(idCounter.getAndIncrement(), "Audi", "A4", 2023, "Gray", 2.0, "Gasoline", 38000.00, 4,
                "Automatic", 16000));
        cars.add(new Car(idCounter.getAndIncrement(), "Tesla", "Model 3", 2023, "White", 0.0, "Electric", 42000.00, 4,
                "Automatic", 10000));
        cars.add(new Car(idCounter.getAndIncrement(), "Volkswagen", "Golf", 2023, "Green", 1.5, "Gasoline", 28000.00, 5,
                "Manual", 14000));
        cars.add(new Car(idCounter.getAndIncrement(), "Hyundai", "Tucson", 2023, "Orange", 2.0, "Gasoline", 32000.00, 5,
                "Automatic", 17000));
        cars.add(new Car(idCounter.getAndIncrement(), "Kia", "Sportage", 2023, "Blue", 1.6, "Gasoline", 30000.00, 5,
                "Automatic", 19000));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public Optional<Car> getCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    public Car createCar(Car car) {
        car.setId(idCounter.getAndIncrement());
        cars.add(car);
        return car;
    }

    public Optional<Car> updateCar(Long id, Car carDetails) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                carDetails.setId(id);
                cars.set(i, carDetails);
                return Optional.of(carDetails);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCar(Long id) {
        return cars.removeIf(car -> car.getId().equals(id));
    }

    public List<Car> getCarsByBrand(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public List<Car> getCarsByYear(Integer year) {
        return cars.stream()
                .filter(car -> car.getYear().equals(year))
                .toList();
    }
}