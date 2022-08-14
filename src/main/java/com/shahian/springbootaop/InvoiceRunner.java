package com.shahian.springbootaop;

import com.shahian.springbootaop.Service.InvoiceBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRunner implements CommandLineRunner {
    @Autowired
    InvoiceBusinessService invoiceBusinessService;
    @Override
    public void run(String... args) throws Exception {
        invoiceBusinessService.saveInvoice();
        invoiceBusinessService.testMethodforAroundAdvice();
        invoiceBusinessService.saveInvoice();

    }
}
