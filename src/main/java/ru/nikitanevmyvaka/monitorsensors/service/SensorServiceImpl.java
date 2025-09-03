package ru.nikitanevmyvaka.monitorsensors.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorCreateRequest;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorResponse;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorUpdateRequest;
import ru.nikitanevmyvaka.monitorsensors.exceptions.ConflictException;
import ru.nikitanevmyvaka.monitorsensors.exceptions.MissingArgumentException;
import ru.nikitanevmyvaka.monitorsensors.mapper.SensorMapper;
import ru.nikitanevmyvaka.monitorsensors.model.Sensor;
import ru.nikitanevmyvaka.monitorsensors.repository.SensorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorMapper mapper;
    private final SensorRepository repository;

    @Transactional
    public SensorResponse createSensor(SensorCreateRequest dto) {

        if (!dto.range().isValidRange()) throw new IllegalArgumentException("Range is not valid");

        Sensor sensor = mapper.toEntity(dto);

        return mapper.toResponse(repository.save(sensor));

    }

    @Transactional
    public SensorResponse updateSensor(SensorUpdateRequest dto) {
        Sensor sensor = repository.findById(dto.id())
                .orElseThrow(() -> new MissingArgumentException("This sensor doesn't exist"));

        mapper.update(sensor, dto);

        return mapper.toResponse(repository.save(sensor));
    }


    public List<SensorResponse> getAllSensors() {
        return repository.findAll().stream().map(mapper::toResponse)
                .collect(Collectors.toList());
    }


    public SensorResponse getSensor(Long id) {
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new MissingArgumentException("This sensor doesn't exist")));
    }

    @Transactional
    public void deleteSensor(Long id) {
        repository.deleteById(id);

    }
}
