package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.ShipmentInformation;
import org.mannayakasha.service.interfaces.IShipmentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/shipmentInformation")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
@CrossOrigin
public class ShipmentInformationController {

	@Autowired
    private IShipmentInformationService shipmentInformationService;

    @GetMapping("/shipmentInformation/{id}")
    public ResponseEntity<ShipmentInformation> getShipmentInformationById(@PathVariable Integer id) {
        ShipmentInformation shipmentInformation = shipmentInformationService.getById(id);
        return new ResponseEntity<ShipmentInformation>(shipmentInformation, HttpStatus.OK);
    }

    @PostMapping("shipmentInformation")
    public ResponseEntity<Void> create(@RequestBody ShipmentInformation shipmentInformation, UriComponentsBuilder builder) {
        boolean flag = shipmentInformationService.create(shipmentInformation);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/shipmentInformation?id={id}").buildAndExpand(shipmentInformation.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("shipmentInformation")
    public ResponseEntity<ShipmentInformation> update(@RequestBody ShipmentInformation shipmentInformation) {
        shipmentInformationService.update(shipmentInformation);
        return new ResponseEntity<ShipmentInformation>(shipmentInformation, HttpStatus.OK);
    }

    @DeleteMapping("shipmentInformation")
    public ResponseEntity<Void> delete(@RequestParam("id") String id) {
        shipmentInformationService.delete(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
