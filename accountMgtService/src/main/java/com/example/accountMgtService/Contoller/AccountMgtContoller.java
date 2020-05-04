package com.example.accountMgtService.Contoller;





import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.accountMgtService.dao.AccountRepository;
import com.example.accountMgtService.dto.OrderItemDto;
import com.example.accountMgtService.exception.ResourceNotFoundException;
import com.example.accountMgtService.model.Item;
import com.example.accountMgtService.model.OrderItem;
import com.example.accountMgtService.model.SellingOrder;
import com.example.accountMgtService.model.Sorder;
import com.example.accountMgtService.service.AccountService;
import com.example.accountMgtService.service.ItemService;
import com.example.accountMgtService.service.OrderItemService;
import com.example.accountMgtService.service.OrderService;
import com.sun.istack.NotNull;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")

//@RestController
public class AccountMgtContoller {

	@Autowired 
	AccountService accountService ;
	@Autowired 
	ItemService itemService ;
	
	@Autowired 
	OrderService orderService ;
	
	@Autowired 
	OrderItemService orderItemService ;
	
	
	
	
	@Autowired 
	AccountRepository accountRepository ;
	
	
	@RequestMapping("/accountMgtService/{id}")
	
	public Optional<SellingOrder> getProduct(@PathVariable Long id) {

		 return accountService.getById(id);
	}

	 @GetMapping("/items")
	    public @NotNull Iterable<Item> getItems() {
	        return itemService.getAllItems();
	    }

	 @GetMapping("/bill/{id}")
	    public ResponseEntity<Optional<SellingOrder>> getEmployeeById(@PathVariable(value = "id") Long id)
	         {
		 Optional<SellingOrder> sellingOrder = accountService.getById(id);
	          
	        return ResponseEntity.ok().body(sellingOrder);
	    }

	 @GetMapping("/orders")
	 
	    public @NotNull Iterable<Sorder> list() {
	        return this.orderService.getAllOrders();
	    }
	 @PostMapping
	    public ResponseEntity<Sorder> create(@RequestBody OrderForm form) {
	        List<OrderItemDto> formDtos = form.getItemOrders();
	        validateProductsExistence(formDtos);
	        Sorder sorder = new Sorder();
	       // order.setStatus(OrderStatus.PAID.name());
	        sorder = this.orderService.create(sorder);

	        List<OrderItem> orderItems = new ArrayList<>();
	        for (OrderItemDto dto : formDtos) {
	        	orderItems.add(orderItemService.create(new OrderItem(sorder, itemService.getItem(dto
	              .getItem()
	              .getId()), dto.getQuantity())));
	        }

	        sorder.setOrderItems(orderItems);

	        this.orderService.update(sorder);

	        String uri = ServletUriComponentsBuilder
	          .fromCurrentServletMapping()
	          .path("/orders/{id}")
	          .buildAndExpand(sorder.getId())
	          .toString();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Location", uri);

	        return new ResponseEntity<>(sorder, headers, HttpStatus.CREATED);
	    }

	    private void validateProductsExistence(List<OrderItemDto> orderItems) {
	        List<OrderItemDto> list = orderItems
	          .stream()
	          .filter(op -> Objects.isNull(itemService.getItem(op
	            .getItem()
	            .getId())))
	          .collect(Collectors.toList());

	        //if (!CollectionUtils.isEmpty(list)) {
	            new ResourceNotFoundException("Product not found");
	        }
	    }

	     class OrderForm {

	        private List<OrderItemDto> itemOrders;

	        public List<OrderItemDto> getItemOrders() {
	            return itemOrders;
	        }

	        public void setItemOrders(List<OrderItemDto> itemOrders) {
	            this.itemOrders = itemOrders;
	        }
	    }
	 
