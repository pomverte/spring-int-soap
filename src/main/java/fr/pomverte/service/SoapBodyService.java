package fr.pomverte.service;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import fr.pomverte.soap.FahrenheitToCelsius;
import fr.pomverte.soap.ObjectFactory;

@Component
public class SoapBodyService {

    @Autowired
    private ObjectFactory objectFactory;

    @ServiceActivator
    public String stringSoapBody() {
        return "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">" + "<Fahrenheit>90.0</Fahrenheit>"
                + "</FahrenheitToCelsius>";
    }

    @ServiceActivator
    public JAXBElement<FahrenheitToCelsius> jaxbSoapBody() {
        FahrenheitToCelsius fahrenheitToCelsius = this.objectFactory.createFahrenheitToCelsius();
        fahrenheitToCelsius.setFahrenheit("90.0");
        return new JAXBElement<FahrenheitToCelsius>(new QName("http://www.w3schools.com/xml/", "FahrenheitToCelsius"),
                FahrenheitToCelsius.class, fahrenheitToCelsius);
    }
}
