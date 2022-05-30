package com.example.callingexternalapi.v1.integration;

import com.example.callingexternalapi.v1.integration.model.request.RoutesIntegrationRequest;
import com.example.callingexternalapi.v1.integration.model.response.RoutesIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@AllArgsConstructor

public class RoutesIntegration {
	private static final String API_KEY = "AIzaSyBHPJ4BG_aSlO5nKPNdURmO-Es";

	@Autowired
	private final RestTemplate restTemplate;

    public RoutesIntegrationResponse getRoutes(RoutesIntegrationRequest routesIntegrationRequest){

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("maps.googleapis.com")
				.path("/maps/api/distancematrix/json")
				.queryParam("origins", routesIntegrationRequest.getOriginAddresses())
				.queryParam("destinations", routesIntegrationRequest.getDestinationAddresses())
				.queryParam("units","metric")
                .queryParam("key", API_KEY)
                .build();

		return restTemplate.getForObject(uri.toUriString(), RoutesIntegrationResponse.class);

    }
}
