package fr.pomverte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import fr.pomverte.jaxb.temperature.FahrenheitToCelsius;
import fr.pomverte.jaxb.temperature.ObjectFactory;

@Component
public class SoapBodyService {

    @Autowired
    private ObjectFactory temperatureFactory;

    @ServiceActivator
    public String stringSoapBody() {
        return "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">" + "<Fahrenheit>90.0</Fahrenheit>"
                + "</FahrenheitToCelsius>";
    }

    @ServiceActivator
    public FahrenheitToCelsius jaxbSoapBody() {
        FahrenheitToCelsius fahrenheitToCelsius = this.temperatureFactory.createFahrenheitToCelsius();
        fahrenheitToCelsius.setFahrenheit("90.0");
        return fahrenheitToCelsius;
    }
}
