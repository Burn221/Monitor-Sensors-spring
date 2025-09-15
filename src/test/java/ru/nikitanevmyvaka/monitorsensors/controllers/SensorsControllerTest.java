package ru.nikitanevmyvaka.monitorsensors.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.nikitanevmyvaka.monitorsensors.Configuration.TestBeans;
import ru.nikitanevmyvaka.monitorsensors.MonitorsensorsApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {MonitorsensorsApplication.class,TestBeans.class})
@AutoConfigureMockMvc
public class SensorsControllerTest {




    @Autowired
    MockMvc mockMvc;

    @Test
    void findAllSensors_ShouldReturnSensorsList() throws Exception{

        this.mockMvc.perform(get("/api/v1/sensors")
                .with(user("admin").roles("ADMIN")))
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.content().json("""
                        [
                        {
                            "id": 1,
                                  "name": "sensor1",
                                  "model": "arg-23",
                                  "range": { "from": 12, "to": 33, "validRange": true },
                                  "type": "voltage",
                                  "unit": "voltage",
                                  "location": "underground",
                                  "description": "voltage sensors"
                            }
                        ]""")
                );




    }

}
