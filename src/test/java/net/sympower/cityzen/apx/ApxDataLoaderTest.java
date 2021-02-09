package net.sympower.cityzen.apx;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import net.sympower.cityzen.apx.entity.Quote;
import net.sympower.cityzen.apx.model.QuoteDto;
import net.sympower.cityzen.apx.model.QuoteResponse;
import net.sympower.cityzen.apx.model.QuoteValue;
import net.sympower.cityzen.apx.util.ApxDataLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApxDataLoaderTest {

  private static final double DELTA = 1e-15;

  @Test
  public void load() throws Exception {

    ApxDataLoader apxDataLoader = new ApxDataLoader();
    apxDataLoader.fileStr = getClass().getResource("/apx-data.json").getFile();
    apxDataLoader.file = new File(apxDataLoader.fileStr);

    List<QuoteDto> response = apxDataLoader.load();

    assertNotNull(response.equals(null));
    assertNotNull(response.isEmpty());
    Assert.assertTrue(response.size() > 0);

    QuoteDto quoteFields = response.get(0);
    QuoteValue quoteValueFields = response.get(0).quoteValues.get(0);
    assertNotNull(quoteFields.equals(null));
    assertNotNull(quoteValueFields.equals(null));

  }

  @Test
  public void parseTest() throws Exception {

    ApxDataLoader apxDataLoader = new ApxDataLoader();
    apxDataLoader.fileStr = getClass().getResource("/apx-data.json").getFile();
    apxDataLoader.file = new File(apxDataLoader.fileStr);

    List<QuoteDto> response = apxDataLoader.load();
    System.out.println(response);

    JsonFactory factory = new JsonFactory();
    JsonParser parser = factory.createParser(apxDataLoader.file);

    System.out.println("*******" + parser.toString());
    QuoteDto quoteDto = new QuoteDto();
    QuoteValue quoteValue = new QuoteValue();
    while (!parser.isClosed()) {
      JsonToken jsonToken = parser.nextToken();

      System.out.println("jsonToken = " + jsonToken);

      if (JsonToken.FIELD_NAME.equals(jsonToken)) {
        String fieldName = parser.getCurrentName();
        System.out.println(fieldName);

        jsonToken = parser.nextToken();

        if ("market".equals(fieldName)) {
          quoteDto.setMarket(parser.getValueAsString());
          System.out.println("quote.market =" + quoteDto.getMarket());
          assertEquals("market", fieldName);
        }
        else if ("date_applied".equals(fieldName)) {
          quoteDto.setDateApplied(parser.getValueAsString());
          System.out.println("quote.dateApplied =" + quoteDto.getDateApplied());
          assertEquals("date_applied", fieldName);
        }
        else if ("tLabel".equals(fieldName)) {
          quoteValue.settLabel(parser.getValueAsString());
          System.out.println("quoteValue.tLabel =" + quoteValue.tLabel);
          assertEquals("tLabel", fieldName);
        }
        else if ("value".equals(fieldName)) {
          quoteValue.setValue(Double.parseDouble(parser.getValueAsString()));
          System.out.println("quoteValue.value =" + quoteValue.value);
          assertEquals("value", fieldName);
        }
      }

    }
  }

}