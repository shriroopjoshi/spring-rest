package controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.AboutMessage;

@RestController
public class AboutController {
    private static final String template = "Hello %s. This is an API created to try out Spring";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/about")
    public AboutMessage about(@RequestParam(value="name", defaultValue="world") String name) {
        return new AboutMessage(counter.incrementAndGet(), String.format(template, name));
    }
}
