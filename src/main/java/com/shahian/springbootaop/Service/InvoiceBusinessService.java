package com.shahian.springbootaop.Service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class InvoiceBusinessService {
    public void saveInvoice(){
        System.out.println("From Save Invoice");
        if (new Random().nextInt(15)<10){
            throw new RuntimeException("Exception occured...");
        }
    }
    public String helloInvoice(){
        return "From helloInvoice";
    }
    public void testMethodforAroundAdvice() {
        System.out.println("Business Method is getting Executed !");
    }
}
