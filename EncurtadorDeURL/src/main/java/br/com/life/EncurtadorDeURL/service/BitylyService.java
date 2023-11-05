package br.com.life.EncurtadorDeURL.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BitylyService {
    private Bitly client;
    @Value("${BITLY_TOKEN}")
    String BITLY_TOKEN;

    @PostConstruct
    public void setup() {
        client = new Bitly(BITLY_TOKEN);
    }

    public String getShortURL(String longURL) {
        String link = "error";

        try {
            CreateBitlinkResponse response = client.bitlinks().shorten(longURL).get();

            link = response.getLink();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return link;
    }
}
