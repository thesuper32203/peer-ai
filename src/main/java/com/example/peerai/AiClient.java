package com.example.peerai;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public class AiClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();


}
