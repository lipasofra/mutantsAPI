package com.mutantsapi.mutants.controllers;

import com.mutantsapi.mutants.models.DNA;
import com.mutantsapi.mutants.models.Stats;
import com.mutantsapi.mutants.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;


    @Test
    void statistics() throws Exception {

        PersonService personService = Mockito.mock(PersonService.class);

        when(personService.mutantsQuantity(true)).thenReturn(4L);
        when(personService.mutantsQuantity(false)).thenReturn(2L);
        when(personService.mutantsRatio(4L, 2L)).thenReturn(2.0);

        PersonController personController = new PersonController(personService);

        assertNotNull(personController.statistics());
        assertTrue(personController.statistics() instanceof Stats);

    }

    @Test
    void newHuman() throws Exception{

        when(personService.save((any())))
        RequestBuilder request = MockMvcRequestBuilders.post("/mutant/");
        MvcResult result = mockMvc.perform(request)
                .andDo(save())
                .andExpect(HttpStatus.BAD_REQUEST)



    }



    @Test
    void other_type_input_dna() {

        DNA dna = new DNA();

        //Throwable exception = assertThrows(InputTypeExceptionHandler.class,
        //  ()->{dna.setDna("WRONG");} );
    }
}