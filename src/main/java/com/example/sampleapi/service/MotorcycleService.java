package com.example.sampleapi.service;

import com.example.sampleapi.model.Motorcycle;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MotorcycleService {
    private final List<Motorcycle> motorcycles = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public MotorcycleService() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Honda", "CBR600RR", 2023, "Black", 600, "Gasoline",
                12000.00, "Sport", "Manual", 8000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Yamaha", "YZF-R1", 2023, "Blue", 1000, "Gasoline",
                18000.00, "Sport", "Manual", 5000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Kawasaki", "Ninja 650", 2023, "Green", 650,
                "Gasoline", 8500.00, "Sport", "Manual", 12000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Suzuki", "GSX-R750", 2023, "White", 750,
                "Gasoline", 14000.00, "Sport", "Manual", 9000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Ducati", "Panigale V4", 2023, "Red", 1103,
                "Gasoline", 25000.00, "Sport", "Manual", 3000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "BMW", "R 1250 GS", 2023, "Gray", 1254, "Gasoline",
                22000.00, "Adventure", "Manual", 15000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Harley-Davidson", "Street Glide", 2023, "Black",
                1868, "Gasoline", 28000.00, "Cruiser", "Manual", 20000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Triumph", "Bonneville T120", 2023, "Green", 1200,
                "Gasoline", 16000.00, "Classic", "Manual", 18000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "KTM", "Duke 390", 2023, "Orange", 373, "Gasoline",
                6500.00, "Naked", "Manual", 11000));
        motorcycles.add(new Motorcycle(idCounter.getAndIncrement(), "Aprilia", "RS 660", 2023, "Red", 659, "Gasoline",
                12000.00, "Sport", "Manual", 7000));
    }

    public List<Motorcycle> getAllMotorcycles() {
        return new ArrayList<>(motorcycles);
    }

    public Optional<Motorcycle> getMotorcycleById(Long id) {
        return motorcycles.stream()
                .filter(motorcycle -> motorcycle.getId().equals(id))
                .findFirst();
    }

    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
        motorcycle.setId(idCounter.getAndIncrement());
        motorcycles.add(motorcycle);
        return motorcycle;
    }

    public Optional<Motorcycle> updateMotorcycle(Long id, Motorcycle motorcycleDetails) {
        for (int i = 0; i < motorcycles.size(); i++) {
            if (motorcycles.get(i).getId().equals(id)) {
                motorcycleDetails.setId(id);
                motorcycles.set(i, motorcycleDetails);
                return Optional.of(motorcycleDetails);
            }
        }
        return Optional.empty();
    }

    public boolean deleteMotorcycle(Long id) {
        return motorcycles.removeIf(motorcycle -> motorcycle.getId().equals(id));
    }

    public List<Motorcycle> getMotorcyclesByBrand(String brand) {
        return motorcycles.stream()
                .filter(motorcycle -> motorcycle.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public List<Motorcycle> getMotorcyclesByType(String type) {
        return motorcycles.stream()
                .filter(motorcycle -> motorcycle.getType().equalsIgnoreCase(type))
                .toList();
    }

    public List<Motorcycle> getMotorcyclesByYear(Integer year) {
        return motorcycles.stream()
                .filter(motorcycle -> motorcycle.getYear().equals(year))
                .toList();
    }
}