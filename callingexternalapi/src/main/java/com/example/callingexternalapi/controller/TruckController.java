package com.example.callingexternalapi.controller;

import com.example.callingexternalapi.integration.RoutesIntegration;
import com.example.callingexternalapi.integration.model.request.RoutesIntegrationRequest;
import com.example.callingexternalapi.integration.model.response.RoutesIntegrationResponse;
import com.example.callingexternalapi.model.routes.RoutesRequest;
import com.example.callingexternalapi.model.routes.RoutesResponse;
import com.example.callingexternalapi.model.truck.TruckRequest;
import com.example.callingexternalapi.model.truck.TruckResponse;
import com.example.callingexternalapi.service.TruckService;
import lombok.AllArgsConstructor;
import okhttp3.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/truck")
public class TruckController {

    private final TruckService truckService;

    private final RoutesIntegration routesIntegration;
    @GetMapping
    public List<TruckResponse> getTrucks(@RequestParam("id") List<String> id){
        return this.truckService.getTrucksByIdOrAll(id);
    }
    @PostMapping
    public TruckResponse createNewTruck(@RequestBody TruckRequest truckRequest){
        return this.truckService.createTruck(truckRequest);
    }
    @PutMapping("/{id}")
    public TruckResponse updateTruckData(@RequestBody TruckRequest truckRequest,
                                         @PathVariable(value="id") String id){
       return this.truckService.updateDataById(id, truckRequest);
    }
    @DeleteMapping("/delete")
    public void deleteTruck(@RequestParam("id") List<String> id){
        this.truckService.deleteTruckByIdOrAll(id);
    }


    @PostMapping("/newroute/{id}")
    public TruckResponse updateTruckRouteById(@PathVariable(value = "id") String id,
                                              @RequestBody RoutesIntegrationRequest routesIntegrationRequest){
        return this.truckService.updateTrucksRoute(id, routesIntegrationRequest); }

    @DeleteMapping("/routeDelete/{id}")
    public void deleteRouteTruckById(@PathVariable(value = "id") String id){

       this.truckService.deleteRouteTruckById(id);
    }
}