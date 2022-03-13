package com.github.austindoupnik.lombok_and_jackson.value_builder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
  String name;
  int age;
}
