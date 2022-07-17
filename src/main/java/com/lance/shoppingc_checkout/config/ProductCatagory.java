package com.lance.shoppingc_checkout.config;

import java.util.HashMap;
import java.util.Map;

public class ProductCatagory {
        public static String  catagory;
        public static Map<String, String> productCatagoryMap = new HashMap<>();

        public Map productCatagoryMap(){
                productCatagoryMap.put("potato chips","food");
                productCatagoryMap.put("shirt","clothing");
                productCatagoryMap.put("book","others");
                productCatagoryMap.put("pencils","others");
                return productCatagoryMap;
        }

        public String catagoryfilter(String item){
                productCatagoryMap();
                catagory=productCatagoryMap.get(item);
                return catagory;
        }
}
