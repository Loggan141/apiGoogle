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
	private static final String API_KEY = "AIzaSyBHPJ4BG_aSyl4DnKPNdURmO-Es";

	@Autowired
	private final RestTemplate restTemplate;

    public RoutesIntegrationResponse getRoutes(RoutesIntegrationRequest routesIntegrationRequest){

	//https://maps.googleapis.com/maps/api/distancematrix/json?origins=CANOAS
		// &destinations=MARAU&units=imperial&key=AIzaSyBHPJ4BG_aSylNdURmO-Es

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("maps.googleapis.com")
				.path("/maps/api/distancematrix/json")
				.queryParam("origins", routesIntegrationRequest.getOriginAddresses())
				.queryParam("destinations", routesIntegrationRequest.getDestinationAddresses())
				.queryParam("units","metric")
                .queryParam("key", API_KEY)
                .build();


		RoutesIntegrationResponse routesIntegrationResponse = restTemplate.getForObject(uri.toUriString(), RoutesIntegrationResponse.class);

        return routesIntegrationResponse;
    }
}














//    private GeoApiContext context;
//    DistanceMatrixApiRequest s = DistanceMatrixApi.getDistanceMatrix(context, originAddress, destinationAddress);
//    OkHttpClient client = new OkHttpClient().newBuilder().build();
//    Request request = new Request.Builder()
//            .url("https://maps.googleapis.com/maps/api/distancematrix/json?origins=40" +
//                    ".6655101%2C-73.89188969999998&destinations=40.659569%2C-73.933783%7C40.729029%2C-73" +
//                    ".851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key="+"API_KEY")
//            .method("GET", null)
//            .build();
//
//    Response response = client.newCall(request).execute();
//
//    }




