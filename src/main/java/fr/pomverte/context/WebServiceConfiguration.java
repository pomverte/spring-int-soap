package fr.pomverte.context;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Create a new class with Spring WS related beans configuration.
 *
 */
@EnableWs
@Configuration
public class WebServiceConfiguration {
// must it extends WsConfigurerAdapter ?

    /** Spring WS uses a different servlet type for handling SOAP messages: MessageDispatcherServlet */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /**
     * http://localhost:8080/ws/countries.wsdl
     * @return
     */
    @Bean
    public DefaultWsdl11Definition countries() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(this.countriesSchema());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    /**
     * http://localhost:8080/ws/holiday.wsdl
     * 
     * @return
     */
    @Bean
    public DefaultWsdl11Definition holiday() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HolidayResource");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        wsdl11Definition.setSchema(this.holidaySchema());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema holidaySchema() {
        return new SimpleXsdSchema(new ClassPathResource("holiday.xsd"));
    }

}
