# Project exposing  and consuming SOAP services

# Consume
Consume from [http://www.w3schools.com/xml/tempconvert.asmx?WSDL](http://www.w3schools.com/xml/tempconvert.asmx?WSDL) by sending a GET request on
- [http://localhost:8080/string](http://localhost:8080/string)
- [http://localhost:8080/jaxb](http://localhost:8080/jaxb)

# Expose
Guide [https://spring.io/guides/gs/producing-web-service/](https://spring.io/guides/gs/producing-web-service/)
- [http://localhost:8080/ws/countries.wsdl](http://localhost:8080/ws/countries.wsdl)
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
  <soapenv:Header/>
  <soapenv:Body>
    <gs:getCountryRequest>
      <gs:name>Spain</gs:name>
    </gs:getCountryRequest>
  </soapenv:Body>
</soapenv:Envelope>
```
- [http://localhost:8080/ws/holiday.wsdl](http://localhost:8080/ws/holiday.wsdl)

## References
- [ws-outbound-gateway](https://github.com/spring-projects/spring-integration-samples/blob/master/basic/ws-outbound-gateway)
- [ws-inbound-gateway](https://github.com/spring-projects/spring-integration-samples/tree/master/basic/ws-inbound-gateway)
