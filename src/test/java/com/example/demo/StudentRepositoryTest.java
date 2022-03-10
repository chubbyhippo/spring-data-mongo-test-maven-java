package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataMongoTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=4.0.2")
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        studentRepository.save(new Student(null, "Chubby", "Hippo"));
    }

    @Test
    void shouldFindStudentByFirstname() {
        List<Student> students = studentRepository.findStudentByFirstname("Chubby");
        Assertions.assertThat(students).isNotEmpty();
    }
}