package br.com.life.EncurtadorDeURL.controller;

import br.com.life.EncurtadorDeURL.infra.records.ShortURL;
import br.com.life.EncurtadorDeURL.infra.records.LongUrl;
import br.com.life.EncurtadorDeURL.service.BitylyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encurtar")
public class EncurtarUrlController {

    @Autowired
    BitylyService bitylyService;

    @PostMapping
    private ResponseEntity encutarURL(@RequestBody LongUrl dados) {
        String shortURL = bitylyService.getShortURL(dados.longurl());
        return ResponseEntity.ok().body(new ShortURL(shortURL));
    }
}
