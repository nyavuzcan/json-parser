package net.sympower.cityzen.apx.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "quotes")
public class Quote {

  private Long quoteId;
  private String market;
  private String dateApplied;
  private List<QuoteValueEntity> quoteValues;

  @Id
  @Column(name = "quote_id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  public Long getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(Long quoteId) {
    this.quoteId = quoteId;
  }
  @Column(name = "market")
  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }
  @Column(name = "applied_date")
  public String getDateApplied() {
    return dateApplied;
  }

  public void setDateApplied(String dateApplied) {
    this.dateApplied = dateApplied;
  }

  @OneToMany(fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  public List<QuoteValueEntity> getQuoteValues() {
    return quoteValues;
  }

  public void setQuoteValues(List<QuoteValueEntity> quoteValues) {
    this.quoteValues = quoteValues;
  }
}
