package net.sympower.cityzen.apx.serviceImpl;

import com.github.dozermapper.core.Mapper;
import net.sympower.cityzen.apx.entity.Quote;
import net.sympower.cityzen.apx.model.AllResponse;
import net.sympower.cityzen.apx.model.QuoteDto;
import net.sympower.cityzen.apx.model.QuoteResponse;
import net.sympower.cityzen.apx.repository.QuoteRepository;
import net.sympower.cityzen.apx.service.IvxApxService;
import net.sympower.cityzen.apx.util.ApxDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IvxApxServiceImpl implements IvxApxService {
  @Autowired
  ApxDataLoader apxDataLoader;
  @Autowired
  QuoteRepository quoteRepository;
  @Autowired
  Mapper mapper;

  @Override
  public List<AllResponse> gelAllEditQuotes() throws IOException {
    List<QuoteDto> quoteDtoList = apxDataLoader.load();
   return editResponse(quoteDtoList);

  }

  @Override
  public void saveQuotes() throws IOException {
    List<QuoteDto> quoteDtoList = apxDataLoader.load();
    List<Quote> quoteList = mapQuotes(quoteDtoList);
    quoteRepository.save(quoteList);

  }

  @Override
  public List<QuoteDto> gelAllQuotes() throws IOException {
    return apxDataLoader.load();
  }

  private List<Quote> mapQuotes(List<QuoteDto> quoteDtoList){
    List<Quote> quoteList = new ArrayList<>();
    for (QuoteDto quoteDto : quoteDtoList){
        Quote quote = mapper.map(quoteDto, Quote.class);
        quoteList.add(quote);
      }
    return quoteList;
  }

  private List<AllResponse> editResponse( List<QuoteDto> quoteDtoList){
    List<AllResponse> allResponseList = new ArrayList<>();
    for (QuoteDto quoteDto : quoteDtoList){
      AllResponse allResponse = new AllResponse();

      allResponse.setMarket(quoteDto.getMarket());
      allResponse.setDate(epochConverter(quoteDto.getDateApplied()));

      String time = quoteDto.getQuoteValues().stream().filter(e->e.tLabel.equals("Hour")).findFirst().get().getValue().toString();
      String timeStr= time.split("\\.")[0];
      if (timeStr.length() == 1){
        allResponse.setHour("0"+timeStr+":00");
      }else {
        allResponse.setHour(timeStr+":00");
      }

      String netVolume = quoteDto.getQuoteValues().stream().filter(e->e.tLabel.equals("Net Volume")).findFirst().get().getValue().toString();
      String volumeUnit = quoteDto.getQuoteValues().stream().filter(e->e.tLabel.equals("Net Volume")).findFirst().get().getUnit().toString();
      allResponse.setNetValue(netVolume+" "+ volumeUnit);


      String price = quoteDto.getQuoteValues().stream().filter(e->e.tLabel.equals("Price")).findFirst().get().getValue().toString();
      String priceUnit = quoteDto.getQuoteValues().stream().filter(e->e.tLabel.equals("Price")).findFirst().get().getUnit().toString();
      allResponse.setPrice(price+" "+priceUnit);

      allResponseList.add(allResponse);
    }
    return allResponseList;
  }

  private String epochConverter(String epoch){
    long epochL = Long.parseLong(epoch);
    Date expiry = new Date(epochL * 1000);
    return expiry.toString();
  }
}
