package com.github.austindoupnik.lombok_and_jackson.value_constructor_properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
  @Test
  void parseJsonValueWithConstructorProperties() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper();

    final Person expected = Person.builder()
        .name("Wanda Maximoff")
        .age(33)
        .build();
    assertEquals(expected, mapper.readValue("{\"name\": \"Wanda Maximoff\", \"age\": 33}", Person.class));
  }
}
