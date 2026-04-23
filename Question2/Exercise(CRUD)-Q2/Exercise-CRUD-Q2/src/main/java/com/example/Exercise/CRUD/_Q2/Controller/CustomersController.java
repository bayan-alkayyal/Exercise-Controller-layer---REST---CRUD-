package com.example.Exercise.CRUD._Q2.Controller;

import com.example.Exercise.CRUD._Q2.ApiResponse.ApiResponse;
import com.example.Exercise.CRUD._Q2.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomersController {

    ArrayList<Customers> customers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customers ;
    }//get or display all customer


    @PostMapping("/add-customer")
    public ApiResponse addCustomer(@RequestBody Customers customers1){
        customers.add(customers1);
        return new ApiResponse ("Customer added successfully !");
    }//add customer to the list


    @DeleteMapping("/delete-customer/{index}")
    public String deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return "Customer removed successfully !";
    }//remove customer


    @PutMapping("/update-customer/{index}")
    public String updateCustomer(@PathVariable int index , @RequestBody Customers customer){
        customers.set(index,customer);
        return "Customer update successfully !";
    }

    @PutMapping("/deposit/{amount}/{index}")
    public String deposit(@PathVariable double amount , @PathVariable int index) {
       Customers customer = customers.get(index);
       customer.setBalance(customer.getBalance() + amount);
        return "Deposit successful";
    }//deposit

    @PutMapping("/withdraw/{amount}/{index}")
    public String withdraw(@PathVariable double amount , @PathVariable int index){
        Customers customer = customers.get(index);
        if(amount > customer.getBalance()){
            return "Withdrawal failed";
        }

        customer.setBalance(customer.getBalance() - amount);
        return "Withdrawal successful";
    }






}
