package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.OrderItem;
import org.mannayakasha.service.interfaces.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Rest controller for the {@link OrderItem} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@RestController
@RequestMapping("/orderItem")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
@CrossOrigin
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping("/orderItem/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer id) {
        OrderItem orderItem = orderItemService.getById(id);
        return new ResponseEntity<OrderItem>(orderItem, HttpStatus.OK);
    }

    @PostMapping("orderItem")
    public ResponseEntity<Void> create(@RequestBody OrderItem orderItem, UriComponentsBuilder builder) {
        boolean flag = orderItemService.create(orderItem);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/orderItem?id={id}").buildAndExpand(orderItem.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("orderItem")
    public ResponseEntity<OrderItem> update(@RequestBody OrderItem orderItem) {
        orderItemService.update(orderItem);
        return new ResponseEntity<OrderItem>(orderItem, HttpStatus.OK);
    }

    @DeleteMapping("orderItem")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        orderItemService.delete(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
