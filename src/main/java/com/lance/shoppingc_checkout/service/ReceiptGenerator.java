package com.lance.shoppingc_checkout.service;


import com.lance.shoppingc_checkout.domain.Product;
import com.lance.shoppingc_checkout.utils.MathUtils;

import java.util.List;

public class ReceiptGenerator {
    taxCalculation tax =new taxCalculation();
    double taxAmount=0;
    double sumTaxAmount = 0;
    double subtotal = 0;
    double totalAmount = 0;


    public void checkout(List<Product> shoppingCart){
        for (Product product :shoppingCart) {
            taxAmount = tax.getTaxAmount(product);
            sumTaxAmount = MathUtils.add(taxAmount,sumTaxAmount);
            subtotal = MathUtils.add(MathUtils.multiply(product.price,product.qyantity),subtotal);
        }
        totalAmount = MathUtils.add(subtotal,sumTaxAmount) ;
        receiptBuild(shoppingCart);
    }

    public void receiptBuild(List<Product> productList){
        StringBuilder stringBuilder = new StringBuilder();
        String formatString = formatUtil(productList);
        stringBuilder.append(String.format(formatString,"item","price","qty"));
        for (Product product:productList) {
            stringBuilder.append((String.format(formatString,product.name,String.format("%.2f",product.price),product.qyantity)));
        }
        stringBuilder.append((String.format(formatString,"subtotal","", String.format("%.2f",subtotal))));
        stringBuilder.append((String.format(formatString,"tax","",String.format("%.2f",sumTaxAmount))));
        stringBuilder.append((String.format(formatString,"total","",String.format("%.2f",totalAmount))));
        System.out.println(stringBuilder.toString());
    }

    private String formatUtil(List<Product> productList){
        int index=0;
        for (int i=1;i<productList.size();i++) {
            if(productList.get(i).name.length() > productList.get(index).name.length()){
                index=i;
            }
        }
        int ml=productList.get(index).name.length()+3;
        StringBuilder sb =new StringBuilder();
        sb.append("%-"+ml+"s%"+ml+"s%"+ml+"s%n");
        return sb.toString();
    }
}
