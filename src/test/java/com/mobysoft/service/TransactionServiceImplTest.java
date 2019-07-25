package com.mobysoft.service;

import com.mobysoft.model.Tag;
import com.mobysoft.model.Transaction;
import com.mobysoft.model.TransactionImpl;
import com.mobysoft.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TransactionServiceImplTest {

    @Mock
    private TransactionRepository mockTransactionRepository;

    @InjectMocks
    private TransactionService transactionService = new TransactionServiceImpl();

    private TransactionImpl transaction;

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

        when(mockTransactionRepository.findAll()).thenReturn(transactionArrayList);

    }

    @Test
    public void TransactionServiceImpl_findAllTransactions_Passes() throws Exception {
        List<TransactionImpl> resultsList = transactionService.findAllTransactions();

        Assert.assertTrue("findAllTransactions() has failed on contains",
                resultsList.contains(transaction));
        Assert.assertEquals("findAllTransactions() has failed on count",
                1,resultsList.size());

    }

}