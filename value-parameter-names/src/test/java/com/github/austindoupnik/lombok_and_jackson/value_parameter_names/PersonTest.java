package com.github.austindoupnik.lombok_and_jackson.value_parameter_names;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
  @Test
  void parseJsonValueWithParameterNames() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper()
        .registerModule(new ParameterNamesModule());

    final Person expected = Person.builder()
        .name("Wanda Maximoff")
        .age(33)
        .build();
    assertEquals(expected, mapper.readValue("{\"name\": \"Wanda Maximoff\", \"age\": 33}", Person.class));
  }
}
