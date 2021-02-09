package net.sympower.cityzen.apx.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sympower.cityzen.apx.model.QuoteDto;
import net.sympower.cityzen.apx.model.QuoteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ApxDataLoader {

  @Value("${apxDataLoader.url}") public String fileStr;

 public File file;

  @PostConstruct
  public void init() throws IOException {
    if (this.file == null) {
      Resource resource = new ClassPathResource(fileStr);
      this.file = resource.getFile();
    }
  }

  public List<QuoteDto> load() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper.readValue(file, QuoteResponse.class).quote;
  }

}
