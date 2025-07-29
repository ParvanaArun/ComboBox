package com.example.ComboBox.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ComboBox.entity.Customer;
import com.example.ComboBox.entity.Item;
import com.example.ComboBox.entity.Sale;
import com.example.ComboBox.repository.CustomerRepository;
import com.example.ComboBox.repository.ItemRepository;
import com.example.ComboBox.repository.SaleRepository;

@Controller
public class SaleController {
   
	private CustomerRepository customerRepository;
	private ItemRepository itemRepository;
	private SaleRepository saleRepository;
	public SaleController(CustomerRepository customerRepository, ItemRepository itemRepository,
			SaleRepository saleRepository) {
		this.customerRepository = customerRepository;
		this.itemRepository = itemRepository;
		this.saleRepository = saleRepository;
	}
	 
	
	@GetMapping("/add-sale")
	public String addSaleForm(Model model) {
		List<Customer> customers=customerRepository.findAll();
		List<Item> items=itemRepository.findAll();
		
		model.addAttribute("customers", customers);
		model.addAttribute("items", items);
		return "add-sale";
		
	}
	
	@PostMapping("/save-sale")
	public String saveSale(@RequestParam("customerid") Long customerId,
			               @RequestParam("itemid") Long itemId,
			               @RequestParam("totalamount") Double totalAmount,
			               @RequestParam("saledate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saleDate
	                       ) {
		Customer customer =customerRepository.findById(customerId)
				.orElseThrow(()-> new IllegalArgumentException("Invalid Customer ID"));
		
		Item item =itemRepository.findById(itemId)
				.orElseThrow(()-> new IllegalArgumentException("Invalid Item ID"));
		
		Sale sale=new Sale();
		sale.setCustomer(customer);
		sale.setItem(item);
		sale.setTotalamount(totalAmount);
		sale.setSaledate(saleDate);
		saleRepository.save(sale);
		item.setPurchasedt(saleDate);
		itemRepository.save(item);
		
		return "redirect:/add-sale?success=true";
		
	}
	 @GetMapping("/add-customer")
	    public String showAddCustomerForm(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "add-customer";
	    }

	    @PostMapping("/save-customer")
	    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
	        customerRepository.save(customer);
	        redirectAttributes.addFlashAttribute("success", "Customer added successfully!");
	        return "redirect:/add-customer";
	    }

	    @GetMapping("/add-item")
	    public String showAddItemForm(Model model) {
	        model.addAttribute("item", new Item());
	        return "add-item";
	    }

	    @PostMapping("/save-item")
	    public String saveItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
	        itemRepository.save(item);
	        redirectAttributes.addFlashAttribute("success", "Item added successfully!");
	        return "redirect:/add-item";
	    }
	@GetMapping("/edit-sale")
	public String editSaleForm(@RequestParam("saleid") Long saleId,
			Model model) {
		Sale sale=saleRepository.findById(saleId).orElseThrow(()-> new IllegalArgumentException("Invalid Sale ID"));
		List<Customer> customers=customerRepository.findAll();
		List<Item> items=itemRepository.findAll();
		model.addAttribute("sale",sale);
		model.addAttribute("customers", customers);
		model.addAttribute("items", items);
		return "edit-sale";
		
	}
	
	@PostMapping("/update-sale")
	public String updateSale(@RequestParam("saleid") Long saleId,
			               @RequestParam("customerid") Long customerId,
			               @RequestParam("itemid") Long itemId,
			               @RequestParam("totalamount") Double totalAmount,
			               @RequestParam("saledate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saleDate
	                       ) {
		Sale existingsale=saleRepository.findById(saleId).orElseThrow(()-> new IllegalArgumentException("Invalid Sale ID"));
		Customer customer =customerRepository.findById(customerId)
				.orElseThrow(()-> new IllegalArgumentException("Invalid Customer ID"));
		
		Item item =itemRepository.findById(itemId)
				.orElseThrow(()-> new IllegalArgumentException("Invalid Item ID"));
		
		existingsale.setCustomer(customer);
		existingsale.setItem(item);
		existingsale.setTotalamount(totalAmount);
		existingsale.setSaledate(saleDate);
		saleRepository.save(existingsale);
		
		return "redirect:/edit-sale?updated=true";
		
	}

	@GetMapping("/report")
	public String saleReport(
	    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
	    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to,
	    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate saledate,
	    @RequestParam(required = false) Long customerid,
	    @RequestParam(required = false) Long itemid,
	    Model model) {

	    List<Sale> sales;

	    // If specific sale date is given, ignore from/to and fetch only that day
	    if (saledate != null) {
	        sales = saleRepository.findBySaledateOrderBySaledateDesc(saledate);
	    } else if (from != null && to != null) {
	        sales = saleRepository.findBySaledateBetweenOrderBySaledateDesc(from, to);
	    } else if (from != null) {
	        sales = saleRepository.findBySaledateOrderBySaledateDesc(from);
	    } else {
	        sales = saleRepository.findAllByOrderBySaledateDesc();
	    }

	    // Apply customer filter
	    if (customerid != null) {
	        sales = sales.stream()
	            .filter(s -> s.getCustomer().getCustomerid().equals(customerid))
	            .toList();
	    }

	    // Apply item filter
	    if (itemid != null) {
	        sales = sales.stream()
	            .filter(s -> s.getItem().getItemid().equals(itemid))
	            .toList();
	    }

	    model.addAttribute("sales", sales);
	    model.addAttribute("customers", customerRepository.findAll());
	    model.addAttribute("items", itemRepository.findAll());
	    return "report";
	}

	@GetMapping("/delete-sale")
	public String deleteSaleForm(@RequestParam("saleid") Long saleId) {
		saleRepository.deleteById(saleId);
		return "redirect:/report?deleted=true";
		
	}
	@GetMapping("/index")
	public String homePage() {
		return "index";
		
	}
}
