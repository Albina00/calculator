package com.example.restservice;

import com.example.logics.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {


    public List<Map<String ,String>> list = new ArrayList<Map<String,String>>() {{
       add(new HashMap<String, String>() {{put("id","1"); put("text","First message");}});
       add(new HashMap<String, String>() {{put("id","1"); put("text","second message");}});
       add(new HashMap<String, String>() {{put("id","1"); put("text","third message");}});
    }};


    private static  String template = "Hello, %s!";
    private  AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/simple")
    public List<Map<String ,String>> list () {
        return list;
    }


}
