package com.hubspot.jinjava.lib.filter;

import static org.assertj.core.api.Assertions.assertThat;

import com.hubspot.jinjava.Jinjava;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class FormatFilterTest {
  Jinjava jinjava;

  @Before
  public void setup() {
    jinjava = new Jinjava();
  }

  @Test
  public void testFormatFilter() {
    assertThat(
        jinjava.render("{{ '%s - %s'|format(\"Hello?\", \"Foo!\") }}", new HashMap<>())
      )
      .isEqualTo("Hello? - Foo!");
  }

  @Test
  public void testFormatNumber() {
    assertThat(jinjava.render("{{ '%,d'|format(10000) }}", new HashMap<>()))
      .isEqualTo("10,000");
  }
}
