package com.ing.bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ing.bank.entities.Customer;
import com.ing.bank.repo.CustomerRepository;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer_registration";
	}
	@PostMapping("/do_register")
	private String registration(@ModelAttribute("customer") Customer customer, Model model) {
		System.out.println(customer.getName());
		
		customerRepository.save(customer);
		System.out.println(customer);
		model.addAttribute("accountNumber", customer.getAccountNumber());
		return "customer_registration";
	}
	
	//depositing money start
	
	@GetMapping("/deposit")
	private String depositMoney() {
		
		return "deposit";
	}
	
	@PostMapping("/deposit_process")
	private String depositRegister(Model model, @ModelAttribute("customer") Customer customer) {//,, @RequestParam("amount") Customer amount

//		System.out.println(customer.getAccountNumber()+ " "+customer.getAmount());
		 Customer customer2 = customerRepository.findById(customer.getAccountNumber()).get();
//		System.out.println(customer2.getAmount());
		int new_amount =customer.getAmount()+customer2.getAmount();
//		System.out.println(new_amount);
		customer2.setAmount(new_amount);
		customerRepository.save(customer2);
		model.addAttribute("new_amount", new_amount);
		
	
		return "deposit";
	}
	
	// depositing money end
	
	//withdrawal of money start
	@GetMapping("/withdraw")
	private String withdrawMoney() {
		
		return "withdraw";
	}
	
	@PostMapping("/withdraw_process")
	private String withdrawProcess(Model model, @ModelAttribute("customer") Customer customer) {
		System.out.println(customer.getAccountNumber()+" "+customer.getAmount());
		Customer customer2 = customerRepository.findById(customer.getAccountNumber()).get();
		System.out.println(customer2);
		System.out.println(customer2.getAmount());
		
		int new_amount = customer2.getAmount()-customer.getAmount();
		if(new_amount<=100 	) {
			model.addAttribute("new_amount_less", customer2.getAmount());
		}
		else {
			customer2.setAmount(new_amount);
			customerRepository.save(customer2);
			model.addAttribute("new_amount", new_amount);
		}
		return "withdraw";
		
	}
	
	//withdrawal of money end
}
