package ru.smartjava.springbootparameters.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.springbootparameters.interfaces.SystemProfile;

@RestController
@ConfigurationProperties("hello")
public class MainController {
    private SystemProfile profile;
    private String from;

    public MainController(SystemProfile profile) {
        this.profile = profile;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @GetMapping("/profile")
    public String getProfile() {
        return profile.getProfile();
    }

    @GetMapping("/")
    private String hello() {
        return String.format("Hello from %s!!", from);
    }
}
