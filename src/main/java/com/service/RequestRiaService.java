package com.service;

import com.domain.Search;
import com.domain.Vehicle;
import com.utils.JsonRiaParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

@Slf4j
@Service
public class RequestRiaService {

    @Autowired
    JsonRiaParser jsonRiaParser;

    public List<Vehicle> findOnRia(Search search){
        try {
            return jsonRiaParser.getEntityFromRiaJson(doRiaRequest(createRiaRequest(search)));
        }catch (IOException e){
            log.error("Error IOException" + e.getMessage());
        }catch (InterruptedException e){
            log.error("Error Interrupted Exception " + e.getMessage());
        }catch (Exception e){
            log.error("Error "+ e.getMessage());
        }
        return null;
    }

    private String createRiaRequest(Search search){
        StringBuilder sb = new StringBuilder();
        sb.append("${values.autoria}");
        sb.append("${values.supersecret}");

        log.info("ria request is:  "+sb.toString());

        return null;
    }

    private String doRiaRequest (String uri) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req=HttpRequest.newBuilder().uri(URI.create(uri))
                .timeout(Duration.ofSeconds(10)).GET().build();
        HttpResponse<String> resp = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        return resp.body();
    }


}
