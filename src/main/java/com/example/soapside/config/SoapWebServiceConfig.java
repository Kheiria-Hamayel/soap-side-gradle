package com.example.soapside.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/soapWS/*");
    }

    @Bean
    public XsdSchema userSchema(){
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }
    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema){
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setSchema(userSchema);
        def.setLocationUri("/soapWS");
        def.setPortTypeName("UserServicePort");
        def.setTargetNamespace("http://soap_side.com");

        return def;
    }
}
