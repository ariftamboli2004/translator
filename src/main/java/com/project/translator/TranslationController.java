package com.project.translator;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TranslationController {

    @PostMapping("/translate")
    public String translate(@RequestBody TranslationRequest request) {

        try {
            String url = "https://translate.googleapis.com/translate_a/single?client=gtx&sl="
                    + request.from + "&tl=" + request.to + "&dt=t&q=" + request.text;

            RestTemplate restTemplate = new RestTemplate();

            String response = restTemplate.getForObject(url, String.class);

            String translated = response.split("\"")[1];

            return translated;

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}