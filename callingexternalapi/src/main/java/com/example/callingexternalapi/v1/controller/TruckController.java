package com.example.callingexternalapi.v1.controller;

import com.example.callingexternalapi.v1.model.routes.RoutesRequest;
import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.service.TruckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Truck Api")
@RequestMapping("/v1/truck")
public class TruckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TruckController.class);
    private final TruckService truckService;

    @ApiOperation(value = "Returns a Truck List by Id or All")
    @GetMapping(produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TruckResponse> getTrucks(@RequestParam List<String> id){
        LOGGER.info("***Getting trucks action called...");

        return this.truckService.getTrucksByIdOrAll(id);
    }


    @ApiOperation(value = "Creates a new truck")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces="application/json", consumes = "application/json")
    public TruckResponse createNewTruck(@RequestBody @Valid TruckRequest truckRequest){
        LOGGER.info("***Creating trucks action called...");
        return this.truckService.createTruck(truckRequest);
    }


    @ApiOperation(value = "Update a truck")
    @PutMapping(produces="application/json", consumes = "application/json")
    public TruckResponse updateTruckData(@Valid @RequestBody TruckRequest truckRequest){
        LOGGER.info("***Updating trucks...");
       return this.truckService.updateDataByIdOrThrowsTruckNotFoundException(truckRequest);
    }



    @ApiOperation(value = "Delete a truck")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTruck(@RequestParam("id") List<String> id){

        LOGGER.info("***Deleting trucks action called...");
        this.truckService.deleteTruckByIdOrAll(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Create a new Route to a Truck by ID")
    @PostMapping(path = "/newroute/{id}", produces="application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TruckResponse updateTruckRouteById(@PathVariable(value = "id") String id,
                                              @RequestBody @Valid RoutesRequest routesRequest){
        LOGGER.info("***Updating truck's route action called...");
        return this.truckService.updateTrucksRouteOrThrowsTruckNotFoundException(id, routesRequest); }




    @ApiOperation(value = "Delete a truck's Route by ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/routeDelete/{id}")
    public ResponseEntity<Void> deleteRouteTruckById(@PathVariable String id){
        LOGGER.info("***Deleting truck's route action called...");

       this.truckService.deleteRouteTruckByIdOrThrowsTruckNotFoundException(id);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}