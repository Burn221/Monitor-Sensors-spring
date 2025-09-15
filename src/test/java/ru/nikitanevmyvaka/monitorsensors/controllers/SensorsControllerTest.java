package ru.nikitanevmyvaka.monitorsensors.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ru.nikitanevmyvaka.monitorsensors.Configuration.TestBeans;
import ru.nikitanevmyvaka.monitorsensors.MonitorsensorsApplication;




@SpringBootTest(classes = {MonitorsensorsApplication.class,TestBeans.class})
@AutoConfigureMockMvc
public class SensorsControllerTest {




    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void findAllSensors_ShouldReturnSensorsList() throws Exception{

        this.mockMvc.perform(get("/api/v1/sensors")
                )
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

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void createSensor_ShouldReturnCreatedEntity() throws Exception{
        this.mockMvc.perform(post("/api/v1/sensors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        
                        {
                                  "name": "sensor2",
                                  "model": "arg-24",
                                  "range": { "from": 13, "to": 33, "validRange": true },
                                  "type": "voltage",
                                  "unit": "voltage",
                                  "location": "surface",
                                  "description": "voltage sensor on surface"
                            }
                        """))

                .andExpectAll(
                        status().isCreated(),
                        MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.id").exists(),
                        MockMvcResultMatchers.jsonPath("$.name").value("sensor2"),
                        MockMvcResultMatchers.jsonPath("$.range.from").value(13),
                        MockMvcResultMatchers.jsonPath("$.range.to").value(33)



                        );

    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void updateSensors_ShouldReturnUpdatedEntity() throws Exception{
        this.mockMvc.perform(put("/api/v1/sensors/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                                  "id": 1,
                                  "name": "sensor3",
                                  "model": "arg-24",
                                  "range": { "from": 13, "to": 33, "validRange": true },
                                  "type": "voltage",
                                  "unit": "voltage",
                                  "location": "underground",
                                  "description": "voltage sensor on surface"
                            }
                        """))
                .andExpectAll(

                        MockMvcResultMatchers.jsonPath("$.id").exists(),
                        MockMvcResultMatchers.jsonPath("$.name").value("sensor3"),
                        MockMvcResultMatchers.jsonPath("$.model").value("arg-24"),
                        MockMvcResultMatchers.jsonPath("$.location").value("underground")
                );




    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    void deleteSensors_ShouldReturnNoContent_AndDeleteFromDB()throws Exception{
        this.mockMvc.perform(delete("/api/v1/sensors/1"))
                .andDo(print())
                .andExpect(status().isNoContent());


    }


}
