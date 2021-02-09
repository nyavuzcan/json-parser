package net.sympower.cityzen.apx.controller;

import net.sympower.cityzen.apx.service.IvxApxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/ivx")

public class IvxParserController {

  @Autowired
  IvxApxService ivxApxService;

  @RequestMapping(value = "/inquireQuotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity getAllQuotes() throws IOException {
    return new ResponseEntity(ivxApxService.gelAllEditQuotes(), HttpStatus.OK);
  }

  @RequestMapping(value = "/saveAllQuotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity saveAllQuotes() throws IOException {
    ivxApxService.saveQuotes();
    return new ResponseEntity("Success", HttpStatus.OK);
  }

  @RequestMapping(value = "/getQuotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity getQuotes() throws IOException {
    return new ResponseEntity( ivxApxService.gelAllQuotes(), HttpStatus.OK);
  }


}
