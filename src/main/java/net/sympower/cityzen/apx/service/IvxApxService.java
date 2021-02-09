package net.sympower.cityzen.apx.service;

import net.sympower.cityzen.apx.model.AllResponse;
import net.sympower.cityzen.apx.model.QuoteDto;
import net.sympower.cityzen.apx.model.QuoteResponse;

import java.io.IOException;
import java.util.List;

public interface IvxApxService {
  List<AllResponse> gelAllEditQuotes() throws IOException;

  List<QuoteDto> gelAllQuotes() throws IOException;

  void saveQuotes() throws IOException;

}
