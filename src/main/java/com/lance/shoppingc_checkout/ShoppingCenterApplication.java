package com.lance.shoppingc_checkout;

import com.lance.shoppingc_checkout.config.ShoppingList;
import com.lance.shoppingc_checkout.domain.Product;
import com.lance.shoppingc_checkout.service.ReceiptGenerator;

import java.util.List;
import java.util.Scanner;

public class ShoppingCenterApplication {
    public static void main(String[] args) throws Exception {
        Interaction();
    }

    private static void showshoppingCart(){
        System.out.println("Your shoppingCart");
        for (int i = 0; i< ShoppingList.myList().size(); i++) {
            System.out.println(i+"-->"+ShoppingList.myList().get(i));
        }
    }

    private static void Interaction(){
        showshoppingCart();
        boolean leave = false;
        while (!leave) {
            System.out.println("Please choice your shoppingCart 0,1,2...");
            try{
                int shoppingCart = new Scanner(System.in).nextInt();
                if(shoppingCart>ShoppingList.myList().size()-1){
                    System.out.println("please choice the available shoppingCart");
//                    Interaction();
                }else{
                    System.out.println("Your shopping receipt");

                    ReceiptGenerator rg = new ReceiptGenerator();
                    rg.checkout((List<Product>) ShoppingList.myList().get(shoppingCart));
                    System.out.println("Do u want to leave? yes/no");
                    String action = new Scanner(System.in).next();
                    if("yes".equals(action)){
                        leave = true;
                        System.out.println("leave");
                    }
                }
            }catch (Exception e){
                System.out.println("Please input Int type" +e.toString());
            }
        }
    }
}
