package ru.nikitanevmyvaka.monitorsensors.service;

import org.springframework.stereotype.Service;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorCreateRequest;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorResponse;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorUpdateRequest;

import java.util.List;


public interface SensorService {

    public SensorResponse createSensor(SensorCreateRequest dto);

    public SensorResponse updateSensor(SensorUpdateRequest dto);

    public List<SensorResponse> getAllSensors();

    public SensorResponse getSensor(Long id);

    public void deleteSensor(Long id);
}
