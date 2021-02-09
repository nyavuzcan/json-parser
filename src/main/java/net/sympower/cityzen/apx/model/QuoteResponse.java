package net.sympower.cityzen.apx.model;

import net.sympower.cityzen.apx.entity.Quote;

import java.util.List;

public class QuoteResponse {

  public List<QuoteDto> quote;

  @Override
  public String toString() {
    return "QuoteResponse{" +
      "quote=" + quote +
      '}';
  }
}
