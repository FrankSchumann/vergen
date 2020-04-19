package com.hubspot.jinjava.interpret;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

public class LazyExpressionTest {

  @Test
  public void itSerializesUnderlyingValue() throws JsonProcessingException {
    LazyExpression expression = LazyExpression.of(
      () -> ImmutableMap.of("test", "hello", "test2", "hello2"),
      "{}"
    );
    Object evaluated = expression.get();
    assertThat(evaluated).isNotNull();
    assertThat(new ObjectMapper().writeValueAsString(expression))
      .isEqualTo("{\"test\":\"hello\",\"test2\":\"hello2\"}");
  }

  @Test
  public void itSerializesNonEvaluatedValueToEmpty() throws JsonProcessingException {
    LazyExpression expression = LazyExpression.of(
      () -> ImmutableMap.of("test", "hello", "test2", "hello2"),
      "{}"
    );
    assertThat(new ObjectMapper().writeValueAsString(expression)).isEqualTo("\"\"");
  }
}
