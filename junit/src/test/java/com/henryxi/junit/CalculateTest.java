package com.henryxi.junit;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculateTest {
    @Test
    public void testCalculateInterest() throws Exception {
        Calculate calculate = new Calculate();
        BigDecimal principal = new BigDecimal(100);
        BigDecimal interestRate = new BigDecimal("0.02");
        BigDecimal interest = new BigDecimal(2).setScale(2);
        Assert.assertEquals(interest,calculate.calculateInterest(principal,interestRate));
    }

    @Test(expected = InterestException.class)
    public void testCalculateException() throws Exception {
        Calculate calculate = new Calculate();
        BigDecimal principal = new BigDecimal(100);
        BigDecimal interestRate = new BigDecimal("0");
        calculate.calculateInterest(principal,interestRate);
    }
}