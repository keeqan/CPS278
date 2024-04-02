package machine5.example.machine5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Display a list of all customers
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    // Find a specific customer by ID and display their details
    @GetMapping("/{id}")
    public String findCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customers/detail"; 
    }

    @GetMapping("/form")
public String showCustomerForm(Model model) {
    Customer customer = new Customer();
    customer.setAddress(new Address()); 
    model.addAttribute("customer", customer);
    return "customers/form";
}



    // Process the form for adding a new customer
    @PostMapping
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/form"; 
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // Delete a specific customer by ID
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers"; 
    }
    
    // Display a form to edit an existing customer
@GetMapping("/edit/{id}")
public String editCustomerForm(@PathVariable Long id, Model model) {
    Customer customer = customerService.findCustomerById(id);
    model.addAttribute("customer", customer);
    return "customers/edit"; 
}

// Process the form for editing an existing customer
@PostMapping("/edit/{id}")
public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute Customer customer, BindingResult result) {
    if (result.hasErrors()) {
        return "customers/edit"; 
    }
    customer.setId(id); 
    customerService.saveCustomer(customer);
    return "redirect:/customers"; 
}

}

