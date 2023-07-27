package ru.smartjava.springbootparameters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Objects;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootParametersApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private final GenericContainer<?> myAppDev = new GenericContainer("devapp")
            .withExposedPorts(8080);

    @Container
    private final GenericContainer<?> myAppProd = new GenericContainer("prodapp")
            .withExposedPorts(8081);

    @Test
    void contextLoads() {
        ResponseEntity<String> forFirstEntity = restTemplate.getForEntity("http://localhost:" + myAppDev.getMappedPort(8080) + "/profile", String.class);
//        System.out.println(forFirstEntity.getBody());
        Assertions.assertTrue(Objects.requireNonNull(forFirstEntity.getBody()).contains("is dev"));
        ResponseEntity<String> forSecondEntity = restTemplate.getForEntity("http://localhost:" + myAppProd.getMappedPort(8081) + "/profile", String.class);
//        System.out.println(forSecondEntity.getBody());
        Assertions.assertTrue(Objects.requireNonNull(forSecondEntity.getBody()).contains("is production"));
    }

}
