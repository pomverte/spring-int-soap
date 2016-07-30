package fr.pomverte.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class SoapBodyService {

    @ServiceActivator
    public String stringSoapBody() {
        return "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">" + "<Fahrenheit>90.0</Fahrenheit>"
                + "</FahrenheitToCelsius>";
    }
}
