package com.mobysoft.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TransactionImplTest {

    TransactionImpl transactionImplUnderTest;
    Set<Enum<?>> tags = new HashSet<>();

    @Before
    public void setUp() throws Exception {

        tags.add(Tag.CHARGE);
        tags.add(Tag.RENT);

        LocalDate localDate = LocalDate.of(2018, Month.APRIL, 01);

        transactionImplUnderTest = new TransactionImpl("rc1", localDate,40000, tags);

    }

    @Test
    public void getId_IdReturned_Passes() throws Exception {
        Assert.assertEquals("getId() has failed",
                "rc1", transactionImplUnderTest.getId());
    }

    @Test
    public void getDate_DateReturned_Passes() throws Exception {

        LocalDate localDate1 = LocalDate.of(2018, Month.APRIL, 01);

        Assert.assertEquals("getDate() has failed",
                localDate1, transactionImplUnderTest.getDate());
    }

    @Test
    public void getTags_TagsReturned_Passes() throws Exception {
        Assert.assertTrue("getTags() has failed",
                tags.containsAll(transactionImplUnderTest.getTags()));
    }

    @Test
    public void getPence_PenceReturned_Passes() throws Exception {
        Assert.assertEquals("getPence() has failed",
                40000, transactionImplUnderTest.getTransactionAmountInPence());
    }

    @Test
    public void hasTag_TagIsGot_Passes() throws Exception {
        System.out.println(transactionImplUnderTest);
        Assert.assertTrue("hasTags() has failed",transactionImplUnderTest.hasTag(Tag.CHARGE));
    }

    @Test
    public void hasTag_TagIsNotGot_Passes() throws Exception {
        Assert.assertFalse("hasTags() has failed",transactionImplUnderTest.hasTag(Tag.PAYMENT));
    }

}