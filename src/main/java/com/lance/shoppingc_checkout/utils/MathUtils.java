package com.lance.shoppingc_checkout.utils;

import java.math.BigDecimal;


public class MathUtils {
    public static double add(double p1, double p2) {
        return BigDecimal.valueOf(p1).add(BigDecimal.valueOf(p2)).doubleValue();
    }

    public static double multiply(double p1,double p2) {
        return BigDecimal.valueOf(p1).multiply(BigDecimal.valueOf(p2)).doubleValue();
    }
}