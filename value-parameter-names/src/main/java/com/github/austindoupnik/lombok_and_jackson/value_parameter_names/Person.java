package com.github.austindoupnik.lombok_and_jackson.value_parameter_names;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_ = @JsonCreator)
public class Person {
  String name;
  int age;
}
