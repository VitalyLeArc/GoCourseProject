package com.service;

import com.domain.Search;
import com.domain.Vehicle;
import com.utils.JsonRiaParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@PropertySource("classpath:values.properties")
class RequestRiaService {
    private String riaLink;
    private String requesKey;
    @Autowired
    public RequestRiaService(@Value("${autoria}") String riaLink,@Value("${supersecret}")String requestKey){
        this.riaLink=riaLink;
        this.requesKey=requestKey;
    }

    @Autowired
    JsonRiaParser jsonRiaParser;

    // Управляет методами для составления запроса на риа, выполнения запроса на риа,
    // парсинга полученных жсонов от риа
    public List<Vehicle> findOnRia(Search search){
        try {
            List<String> vehicles_id = jsonRiaParser.getListVehiclesIdFromRiaJson(doRiaRequest(createRiaRequest(search)));
            List<String> vehiclesJson = new ArrayList<>();
            for (String v:vehicles_id) {
//              log.info(v);
                vehiclesJson.add(doRiaRequest(createRiaVehicleRequest(v)));
            }
            List<Vehicle> vehicles = new ArrayList<>();
            for (String v:vehiclesJson) {
                log.info(v);
                vehicles.add(jsonRiaParser.getEntityFromRiaJson(v));
            }
            return vehicles;
        }catch (IOException e){
            log.error("Error IOException" + e.getMessage());
        }catch (InterruptedException e){
            log.error("Error Interrupted Exception " + e.getMessage());
        }catch (Exception e){
            log.error("Error "+ e.getMessage());
        }
        return null;
    }

    //составляет запрос корректный для РИА из параметров поиска
    private String createRiaRequest(Search search){
        StringBuilder sb = new StringBuilder();
        sb.append(riaLink);
        sb.append("search?");
        sb.append(requesKey);
        if(search.getCategory()!=-1){
            sb.append("&category_id=");
            sb.append(search.getCategory());
        }
        if(search.getBody()!=-1) {
            sb.append("&bodystyle[0]=");
            sb.append(search.getBody());
        }
        if(search.getFuelType()!=-1){
            sb.append("&type[0]=");
            sb.append(search.getFuelType());
        }
        if(search.getMark()!=-1){
            sb.append("&marka_id[0]=");
            sb.append(search.getMark());
        }
        log.info("ria request is:  "+sb.toString());
        return sb.toString();
    }

    //врменный метод. составляет запрос для поиска конкретного объявления на риа
    private String createRiaVehicleRequest(String string){
        StringBuilder sb = new StringBuilder();
        sb.append(riaLink);
        sb.append("info?");
        sb.append(requesKey);
        sb.append("&auto_id=");
        sb.append(string);
        return sb.toString();
    }

    //Выполняет запрос на риа. В ответ приходит жсон, возвращает этот жсон в чистом виде как есть в виде одной строки
    private String doRiaRequest (String uri) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req=HttpRequest.newBuilder().uri(URI.create(uri))
                .timeout(Duration.ofSeconds(10)).GET().build();
        HttpResponse<String> resp = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        return resp.body();
    }


}
