package com.example.ClinicaOdontologica;

import Clinica.ClinicaOdontologica.ClinicaOdontologicaApplication;
import Clinica.ClinicaOdontologica.dto.OdontologoDTO;
import Clinica.ClinicaOdontologica.service.OdontologoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ClinicaOdontologicaApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionOdontologoTest {

    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    public String cargarDatos() throws JsonProcessingException {
        OdontologoDTO odontologo = new OdontologoDTO(1233, "Angel", "Reyes");

        return objectMapper.writeValueAsString(odontologoService.guardarOdontologo(odontologo));
    }

    @Test
    public void guardarOdontologo() throws Exception {

        String odontologoString = cargarDatos();
        MvcResult resultado = mockMvc.perform(post("/odontologos/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(odontologoString))
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(resultado.getResponse().getContentAsString().isEmpty());

    }
}
