package com.kb.kbService;

import java.net.URI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.util.RestComponent;

@Service
public class KbServiceImpl implements KbService {

    @Override
    public String getExchangeRate() throws Exception {
        Document doc = Jsoup.connect("https://obank.kbstar.com/quics?page=C101423").get();
        return doc.getElementById("inqueryTable").html();
    }

}
