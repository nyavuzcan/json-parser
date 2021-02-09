package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuoteDto {
  @JsonProperty("market")
  public String market;

  @JsonProperty("date_applied")
  public String dateApplied;

  @JsonProperty("values")
  public List<QuoteValue> quoteValues;

  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }

  public String getDateApplied() {
    return dateApplied;
  }

  public void setDateApplied(String dateApplied) {
    this.dateApplied = dateApplied;
  }

  public List<QuoteValue> getQuoteValues() {
    return quoteValues;
  }

  public void setQuoteValues(List<QuoteValue> quoteValues) {
    this.quoteValues = quoteValues;
  }

  @Override
  public String toString() {
    return "Quote{" +
        "market='" + market + '\'' +
        ", dateApplied='" + dateApplied + '\'' +
        ", quoteValues=" + quoteValues +
        '}';
  }
}
