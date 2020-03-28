package com.hubspot.jinjava.doc;

import java.util.Map;

public class JinjavaDocExpTest extends JinjavaDocItem {

  public JinjavaDocExpTest(
    String name,
    String desc,
    String aliasOf,
    boolean deprecated,
    JinjavaDocParam[] inputs,
    JinjavaDocParam[] params,
    JinjavaDocSnippet[] snippets,
    Map<String, String> meta
  ) {
    super(name, desc, aliasOf, deprecated, inputs, params, snippets, meta);
  }
}
