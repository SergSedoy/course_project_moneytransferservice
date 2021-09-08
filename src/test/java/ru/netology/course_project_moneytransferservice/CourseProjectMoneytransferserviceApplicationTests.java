package ru.netology.course_project_moneytransferservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseProjectMoneytransferserviceApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    public static GenericContainer<?> transferservice = new GenericContainer<>("transferservice").withExposedPorts(5500);

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost" + transferservice.getMappedPort(5500), String.class);
        System.out.println(forEntity.getBody());
    }

}
