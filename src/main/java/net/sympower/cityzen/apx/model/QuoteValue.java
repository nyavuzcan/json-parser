package net.sympower.cityzen.apx.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteValue {
  @JsonProperty("tLabel")
  public String tLabel;
  @JsonProperty("value")
  public Double value;

  @JsonProperty("unit")
  public String unit;

  public String gettLabel() {
    return tLabel;
  }

  public void settLabel(String tLabel) {
    this.tLabel = tLabel;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "QuoteValue{" +
      "tLabel='" + tLabel + '\'' +
      ", value=" + value +
      '}';
  }
}
