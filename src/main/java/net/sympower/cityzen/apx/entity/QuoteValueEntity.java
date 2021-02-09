package net.sympower.cityzen.apx.entity;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
@Table(name = "quotes_values")
public class QuoteValueEntity {
  private Long quoteValueId;
  private String tLabel;
  private Double value;
  private String unit;

  @Id
  @Column(name = "quote_value_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getQuoteValueId() {
    return quoteValueId;
  }

  public void setQuoteValueId(Long quoteValueId) {
    this.quoteValueId = quoteValueId;
  }

  @Column(name = "t_label")
  public String gettLabel() {
    return tLabel;
  }

  public void settLabel(String tLabel) {
    this.tLabel = tLabel;
  }
  @Column(name = "value")
  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @Column(name = "unit")
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
