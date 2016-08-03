package fr.pomverte.web.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import fr.pomverte.jaxb.countries.GetCountryRequest;
import fr.pomverte.jaxb.countries.GetCountryResponse;
import fr.pomverte.repository.CountryRepository;

/**
 * To create a service endpoint, you only need a POJO with a few Spring WS annotations to handle the incoming SOAP
 * requests.
 * 
 * <code>@Endpoint</code> registers the class with Spring WS as a potential candidate for processing incoming SOAP messages.</br>
 * <code>@PayloadRoot</code> is then used by Spring WS to pick the handler method based on the message's namespace and localPart.</br>
 * <code>@RequestPayload</code> indicates that the incoming message will be mapped to the method's request parameter.</br>
 * The <code>@ResponsePayload</code> annotation makes Spring WS map the returned value to the response payload.
 */
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(this.countryRepository.findCountry(request.getName()));
        return response;
    }
}
