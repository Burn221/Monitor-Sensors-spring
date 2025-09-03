package ru.nikitanevmyvaka.monitorsensors.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Type;
import ru.nikitanevmyvaka.monitorsensors.model.enums.Unit;

@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max=30)
    @Column (name = "sensor_name", nullable = false)
    private String name;

    @NotBlank
    @Size(max = 15)
    @Column(name = "model", nullable = false)
    private String model;

    @Valid
    @Column(name = "range")
    private SensorRange range;

    @NotNull
    @Column(name="type")
    private Type type;

    @NotNull
    @Column(name= "unit")
    private Unit unit;

    @Size(max = 40)
    @Column(name = "location")
    private String location;

    @Size(max = 200)
    @Column(name = "description")
    private String description;







}
