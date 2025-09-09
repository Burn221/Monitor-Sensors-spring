package ru.nikitanevmyvaka.monitorsensors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorCreateRequest;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorResponse;
import ru.nikitanevmyvaka.monitorsensors.dto.SensorUpdateRequest;
import ru.nikitanevmyvaka.monitorsensors.service.SensorServiceImpl;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/api/v1/sensors")
@Tag(name="Sensors", description = "Sensors controller endpoints")
public class SensorController {

    private final SensorServiceImpl service;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Create sensor")
    @PostMapping
    public ResponseEntity<SensorResponse> createSensor(@RequestBody @Valid SensorCreateRequest dto){
        SensorResponse response= service.createSensor(dto);

        return ResponseEntity.created(URI.create("/api/v1/sensors/"+response.id()))
                .body(response);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Update sensor")
    @PutMapping("/{id}")
    public ResponseEntity<SensorResponse> updateSensor(@PathVariable Long id,@RequestBody @Valid SensorUpdateRequest dto){

        SensorUpdateRequest fixed= new SensorUpdateRequest
                (id,
                dto.name(),
                dto.model(),
                dto.range(),
                dto.type(),
                dto.unit(),
                dto.location(),
                dto.description());

        SensorResponse response= service.updateSensor(fixed);

        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Get sensor by id")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SensorResponse> getSensor(@PathVariable Long id){
        SensorResponse response= service.getSensor(id);

        return ResponseEntity.ok(response);
    }


    @PreAuthorize(" hasAuthority('ROLE_VIEWER') || hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Get all sensors")
    @GetMapping
    public List<SensorResponse> getAllSensors(){
        return service.getAllSensors();
    }


    @Operation(summary = "Welcome page")
    @GetMapping("/welcome")
    public String welcomePage(){
        return "Welcome";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(summary = "Delete sensor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id){
        service.deleteSensor(id);

        return ResponseEntity.noContent().build();


    }



}
