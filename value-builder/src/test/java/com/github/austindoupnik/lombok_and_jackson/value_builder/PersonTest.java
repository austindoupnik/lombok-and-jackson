package com.github.austindoupnik.lombok_and_jackson.value_builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
  @JsonDeserialize(builder = Person.PersonBuilder.class)
  public interface PersonMixin {

  }

  @JsonPOJOBuilder(withPrefix = "")
  public interface PersonBuilderMixin {

  }

  @Test
  void parseJsonValueWithBuilder() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper()
        .addMixIn(Person.class, PersonMixin.class)
        .addMixIn(Person.PersonBuilder.class, PersonBuilderMixin.class);

    final Person expected = Person.builder()
        .name("Wanda Maximoff")
        .age(33)
        .build();
    assertEquals(expected, mapper.readValue("{\"name\": \"Wanda Maximoff\", \"age\": 33}", Person.class));
  }
}
