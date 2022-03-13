package com.github.austindoupnik.lombok_and_jackson.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
  @Test
  void parseJsonData() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper();

    final Person expected = Person.builder()
        .name("Wanda Maximoff")
        .age(33)
        .build();
    assertEquals(expected, mapper.readValue("{\"name\": \"Wanda Maximoff\", \"age\": 33}", Person.class));
  }
}
