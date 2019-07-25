package com.mobysoft.controller;

import com.mobysoft.Application;
import com.mobysoft.model.Tag;
import com.mobysoft.model.TransactionImpl;
import com.mobysoft.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RESTControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    private TransactionImpl transaction;

    @Mock
    private TransactionService mockTransactionService;

    @InjectMocks
    private RESTController restController;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        Set<Enum<?>> tags = new HashSet<>();

        tags.add(Tag.CHARGE);
        tags.add(Tag.RENT);

        LocalDate localDate = LocalDate.of(2018, Month.APRIL, 01);

        transaction = new TransactionImpl("rc1", localDate,40000, tags);

        List<TransactionImpl> transactionArrayList = new ArrayList<>();
        transactionArrayList.add(transaction);

        when(mockTransactionService.findAllTransactions()).thenReturn(transactionArrayList);

        mockTransactionService = mock(TransactionService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(restController).build();

    }

    @Test
    public void getAllTransactions_allTransactionsAreGot_Passes() throws Exception {

        mockMvc.perform(get("/api/v1/transactions"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.[0].id", is(transaction.getId())));

    }

}