package com.example.callingexternalapi.v1.controller;

import com.example.callingexternalapi.v1.model.routes.RoutesRequest;
import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.service.TruckService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/truck")
public class TruckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TruckController.class);
    private final TruckService truckService;

    @GetMapping
    public ResponseEntity<List<TruckResponse>> getTrucks(@RequestParam List<String> id){
        LOGGER.info("***Getting trucks action called...");
        return new ResponseEntity<>(this.truckService.getTrucksByIdOrAll(id), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TruckResponse createNewTruck(@RequestBody @Valid TruckRequest truckRequest){
        LOGGER.info("***Creating trucks action called...");
        return this.truckService.createTruck(truckRequest);
    }
    @PutMapping("/{id}")
    public TruckResponse updateTruckData(@RequestBody @Valid TruckRequest truckRequest){
        LOGGER.info("***Updating trucks...");
       return this.truckService.updateDataByIdOrThrowsTruckNotFoundException(truckRequest);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTruck(@RequestParam("id") List<String> id){

        LOGGER.info("***Deleting trucks action called...");
        this.truckService.deleteTruckByIdOrAll(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/newroute/{id}")
    public TruckResponse updateTruckRouteById(@PathVariable(value = "id") String id,
                                              @RequestBody @Valid RoutesRequest routesRequest){
        LOGGER.info("***Updating truck's route action called...");
        return this.truckService.updateTrucksRouteOrThrowsTruckNotFoundException(id, routesRequest); }


    @DeleteMapping("/routeDelete/{id}")
    public ResponseEntity<Void> deleteRouteTruckById(@PathVariable String id){
        LOGGER.info("***Deleting truck's route action called...");

       this.truckService.deleteRouteTruckByIdOrThrowsTruckNotFoundException(id);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}