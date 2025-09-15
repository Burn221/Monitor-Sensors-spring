package ru.nikitanevmyvaka.monitorsensors.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.nikitanevmyvaka.monitorsensors.Configuration.TestBeans;
import ru.nikitanevmyvaka.monitorsensors.MonitorsensorsApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {MonitorsensorsApplication.class, TestBeans.class})
@AutoConfigureMockMvc
public class MyUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createNewUser_ShouldReturnUserEntity() throws Exception{
        this.mockMvc.perform(post("/api/v1/users/new-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
                                {
                                  "name": "Nikita",
                                   "password": "1234",
                                   "roles": "ROLE_VIEWER"
                                }
                                """
                ))
                .andExpectAll(


                        MockMvcResultMatchers.content().string("user successfully saved")


                );
    }

}
