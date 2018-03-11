package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.Order;
import org.mannayakasha.entity.OrderItem;
import org.mannayakasha.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Rest controller for the {@link Order} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@RestController
@RequestMapping("/order")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
@CrossOrigin
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("orderItems/{id}")
    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Integer id) {
        List<OrderItem> orderItems = orderService.getOrderItems(id);
        return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("orders/{username}")
    public ResponseEntity<List<Order>> getUserShippedOrders(@PathVariable String username) {
        List<Order> orders = orderService.getUserShippedOrders(username);
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("cart/{username}")
    public ResponseEntity<Order> getCart(@PathVariable String username) {
        Order order = orderService.getCart(username);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("order")
    public ResponseEntity<Void> create(@RequestBody Order order, UriComponentsBuilder builder) {
        boolean flag = orderService.create(order);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/order?id={id}").buildAndExpand(order.getId()).toUri());
        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("order")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        orderService.update(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @DeleteMapping("order")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        orderService.delete(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
