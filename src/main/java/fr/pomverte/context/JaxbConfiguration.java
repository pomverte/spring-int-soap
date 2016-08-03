package fr.pomverte.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.xml.transformer.ResultToStringTransformer;
import org.springframework.integration.xml.transformer.ResultTransformer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import fr.pomverte.jaxb.temperature.ObjectFactory;

@Configuration
public class JaxbConfiguration {

    @Bean
    public ObjectFactory temperatureFactory() {
        return new ObjectFactory();
    }

    @Bean
    public ResultTransformer resultToStringTransformer() {
        return new ResultToStringTransformer();
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("fr.pomverte.jaxb.temperature");
//        marshaller.setContextPaths("fr.pomverte.jaxb.temperature", "fr.pomverte.jaxb.countries");
        return marshaller;
    }

}
