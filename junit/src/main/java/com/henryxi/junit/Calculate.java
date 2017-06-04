package com.henryxi.junit;

import java.math.BigDecimal;

public class Calculate {
    public BigDecimal calculateInterest(BigDecimal principal,BigDecimal interestRate) throws InterestException{
        if(principal.equals(BigDecimal.ZERO)){
            return BigDecimal.ZERO;
        }
        if(interestRate.equals(BigDecimal.ZERO)){
            throw new InterestException("interest can not be 0");
        }
        BigDecimal interest = principal.multiply(interestRate);
//        logger.info("interest: "+interest);
        return interest;
    }
}
