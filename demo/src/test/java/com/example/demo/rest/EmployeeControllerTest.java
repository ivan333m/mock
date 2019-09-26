package com.example.demo.rest;


import com.example.demo.config.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApplicationConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(value = EmployeeController.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class, EmployeeControllerTest.TestConfig.class})
@TestPropertySource(properties = {"spring.main.allow-bean-definition-overriding=true"})
public class EmployeeControllerTest {
//    @LocalServerPort
//    private int port;

    @Configuration
    public static class TestConfig {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    HttpHeaders httpHeaders = new HttpHeaders();

//    private String createURLWithPort(String uri) {
//        return "http://localhost:" + port + uri;
//    }

    @Test
    public void postEmployee()  {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

//        HttpEntity<?> httpEntity = new HttpEntity<>("{\"name\":\"Alex\"}", httpHeaders);
//        ResponseEntity<?> postResponse = this.restTemplate.postForEntity(createURLWithPort("/employee"), httpEntity, String.class);
//        Assert.assertEquals(201, postResponse.getStatusCodeValue());

    }
}