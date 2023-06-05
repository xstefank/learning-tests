package io.xstefank.invoice.rest;

import io.xstefank.invoice.data.InvoiceRepository;
import io.xstefank.invoice.data.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;

        Invoice invoice = new Invoice();
        invoice.setItems(List.of());
        invoice.setTotalPrice(100);

        invoiceRepository.save(invoice);
    }

    @GetMapping("/")
    public String getAllInvoices(Model model) {
        model.addAttribute("invoices", invoiceRepository.findAll());
        return "invoices";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
