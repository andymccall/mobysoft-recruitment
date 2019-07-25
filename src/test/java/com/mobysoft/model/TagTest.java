package com.mobysoft.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TagTest {

    @Test
    public void getDisplayName_IsCharge_Passes() throws Exception {
        Assert.assertEquals(Tag.CHARGE.getDisplayName(),"Charge");
    }

    @Test
    public void getDisplayName_IsRent_Passes() throws Exception {
        Assert.assertEquals(Tag.RENT.getDisplayName(),"Rent");
    }

    @Test
    public void getDisplayName_IsPayment_Passes() throws Exception {
        Assert.assertEquals(Tag.PAYMENT.getDisplayName(),"Payment");
    }

    @Test
    public void getDisplayName_IsCash_Passes() throws Exception {
        Assert.assertEquals(Tag.CASH.getDisplayName(),"Cash");
    }

    @Test
    public void getDisplayName_IsHousingBenefit_Passes() throws Exception {
        Assert.assertEquals(Tag.HOUSING_BENEFIT.getDisplayName(),"HousingBenefit");
    }



}