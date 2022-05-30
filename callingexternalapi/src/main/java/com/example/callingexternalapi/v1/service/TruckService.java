package com.example.callingexternalapi.v1.service;

import com.example.callingexternalapi.v1.exception.TruckNotFoundException;
import com.example.callingexternalapi.v1.integration.RoutesIntegration;
import com.example.callingexternalapi.v1.integration.model.mapper.RoutesIntegrationMapper;
import com.example.callingexternalapi.v1.model.routes.RoutesRequest;
import com.example.callingexternalapi.v1.model.truck.TruckMapper;
import com.example.callingexternalapi.v1.model.truck.TruckRequest;
import com.example.callingexternalapi.v1.model.truck.TruckResponse;
import com.example.callingexternalapi.v1.repository.TruckRepository;
import com.example.callingexternalapi.v1.repository.entity.TruckEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TruckService {
    private TruckRepository truckRepository;
    private RoutesIntegration routesIntegration;

    public List<TruckResponse> getTrucksByIdOrAll(List<String> ids){

        if(ids.isEmpty()){
            return this.truckRepository.findAll()
                    .stream()
                    .map(TruckMapper::truckEntityToResponse)
                    .toList();
        }else{
            return this.truckRepository.findAllByIdIn(ids)
                    .stream()
                    .map(TruckMapper::truckEntityToResponse)
                    .toList();
        }
    }

    public TruckResponse createTruck(TruckRequest truckRequest) {

        TruckEntity truckToCreate = TruckMapper.truckRequestoToEntity(truckRequest);

        this.truckRepository.save(truckToCreate);

        return TruckMapper.truckEntityToResponse(truckToCreate);
    }


    public void deleteTruckByIdOrAll(List<String> ids) {

        if (ids.isEmpty()) {
            this.truckRepository.deleteAll();
        } else {
            this.truckRepository.findAllByIdIn(ids)
                    .stream()
                    .map(TruckEntity::getId)
                    .toList()
                    .forEach(value -> truckRepository.deleteById(value));
        }
    }

    public TruckResponse updateDataByIdOrThrowsTruckNotFoundException(TruckRequest truckRequest) {
        TruckEntity truckToSave = this.truckRepository.findById(truckRequest.getId())
                .orElseThrow(TruckNotFoundException::new);

        truckRequest.setId(truckToSave.getId());
        truckRepository.save(TruckMapper.truckRequestoToEntity(truckRequest));
        return TruckMapper.truckRequestToResponse(truckRequest);
    }

    public TruckResponse updateTrucksRouteOrThrowsTruckNotFoundException(String id,
                                                                         RoutesRequest routesRequest){
        TruckEntity truckToSave = this.truckRepository.findById(id)
                .orElseThrow(TruckNotFoundException::new);
        truckToSave.setId(id);

        var routeIntegrationRequest = RoutesIntegrationMapper.routesRoutesRequestToIntegrationRequest(routesRequest);
        var routeToBeSavedOne = routesIntegration.getRoutes(routeIntegrationRequest);//json com tudo o que recebeu
        //Aqui transforma a Integration Response para RouteEntity
        var routeToBeSavedTwo = RoutesIntegrationMapper.routeIntegrationResponseToRouteEntity(routeToBeSavedOne);

        truckToSave.setRoutesEntity(routeToBeSavedTwo);
        //Add freightcosts
        truckToSave.getRoutesEntity().setFreightCost(freightCost(truckToSave.getRoutesEntity().getDistance().getText()));

        this.truckRepository.save(truckToSave);

        return TruckMapper.truckEntityToResponse(truckToSave);
    }


    public void deleteRouteTruckByIdOrThrowsTruckNotFoundException(String id){
        var truckToDeleteRoute = this.truckRepository.findById(id)
                .orElseThrow(TruckNotFoundException::new);
        truckToDeleteRoute.setId(id);
        truckToDeleteRoute.setRoutesEntity(null);
        this.truckRepository.save(truckToDeleteRoute);
    }


    //Calculo do frete
    public Double freightCost(String distance){
        double distanceToFreight = Double.parseDouble(distance.replaceAll("\\D", ""));
        double distanceToFreightCost=0.0;
        if(distanceToFreight>=1 && distanceToFreight<=100){distanceToFreightCost=(distanceToFreight*2.19);}
        else if((distanceToFreight>100 && distanceToFreight<=200)){distanceToFreightCost=(distanceToFreight*1.35);}
        else if((distanceToFreight>200 && distanceToFreight<=300)){distanceToFreightCost=(distanceToFreight*1.18);}
        else if((distanceToFreight>300 && distanceToFreight<=400)){distanceToFreightCost=(distanceToFreight*1.11);}
        else if((distanceToFreight>400 && distanceToFreight<=500)){distanceToFreightCost=(distanceToFreight*1.07);}
        else if(distanceToFreight>500){distanceToFreightCost=(distanceToFreight*1.01);}

        return distanceToFreightCost;
    }

}


