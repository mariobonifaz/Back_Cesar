package com.example.demo.Controller;

import com.example.demo.Class.SensorData;
import com.example.demo.repositries.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sensor-data")
public class SensorDataController {

    private final SensorDataRepository sensorDataRepository;

    @Autowired
    public SensorDataController(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @PostMapping
    public ResponseEntity<String> addSensorData(@RequestBody SensorData sensorData) {
        sensorDataRepository.save(sensorData);
        return ResponseEntity.ok("Datos recibidos correctamente");
    }

    @GetMapping
    public ResponseEntity<List<SensorData>> getAllSensorData() {
        List<SensorData> sensorDataList = sensorDataRepository.findAll();
        return ResponseEntity.ok(sensorDataList);
    }
}
