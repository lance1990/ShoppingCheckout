package com.lance.shoppingc_checkout.service;


import com.lance.shoppingc_checkout.config.ProductCatagory;
import com.lance.shoppingc_checkout.domain.Product;
import com.lance.shoppingc_checkout.utils.MathUtils;

import java.util.HashMap;
import java.util.Map;


public class taxCalculation {
    ProductCatagory productCatagory = new ProductCatagory();

    public static Map<String, Double> taxcategoryCA = new HashMap<>();
    public static Map<String, Double> taxcategoryNY = new HashMap<>();
    public static Map<String,Map<String, Double>> taxlocationmap =new HashMap<>();


    public Map taxCategory(){
        taxcategoryCA.put("food",0.0);
        taxcategoryCA.put("others",0.0975);
        taxcategoryNY.put("food",0.0);
        taxcategoryNY.put("clothing",0.0);
        taxcategoryNY.put("others",0.08875);

        taxlocationmap.put("CA",taxcategoryCA);
        taxlocationmap.put("NY",taxcategoryNY);
        return taxlocationmap;
    }


    public double getTaxRate( String location,  String itemName) {
        taxCategory();
        for (Map.Entry<String, Map<String, Double>> stringMapEntry : taxlocationmap.entrySet()) {
            if(stringMapEntry.getKey().contains(location)){
                if(stringMapEntry.getValue().containsKey(itemName)){
                    return stringMapEntry.getValue().get(itemName);
                }
                return stringMapEntry.getValue().get("others");
            }
        }
        return 0.0;
    }

    public double getTaxAmount(Product product){
        double taxAmount =  Math.ceil(MathUtils.multiply(MathUtils.multiply(getTaxRate(product.location , productCatagory.catagoryfilter(product.name)),product.price) , product.qyantity) * 20) / 20.0;
        return taxAmount;
    }

}
