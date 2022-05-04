package com.microservices.springdrools.contoller;

import com.microservices.springdrools.model.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservices.springdrools.model.OrderDiscount;
import com.microservices.springdrools.model.OrderRequest;
import com.microservices.springdrools.service.OrderDiscountService;

@RestController
public class OrderDiscountController {

    @Autowired
    private OrderDiscountService orderDiscountService;

    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
    @GetMapping("/order-requests")
    public OrderRequest displayOrderRequest(@RequestParam CustomerType customerType){
        OrderRequest req = new OrderRequest();
        req.setCustomerNumber("1231");
        req.setAge(21);
        req.setAmount(40000);
        req.setCustomerType(customerType);
        return req;
    }
}
