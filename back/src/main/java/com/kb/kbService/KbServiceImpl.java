package com.kb.kbService;

import java.net.URI;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.util.RestComponent;

@Service
public class KbServiceImpl implements KbService {

    @Override
    public String getExchangeRate() throws Exception {
        Response execute = Jsoup.connect("https://obank.kbstar.com/quics?page=C101423").execute();
        Document doc = Jsoup.parse(execute.body());
        return doc.getElementById("inqueryTable").html();
    }

}
