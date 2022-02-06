package me.nastia.robot.services;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class ParseService {

    Pattern pattern = Pattern.compile("\n");

    public List<String> parse(String script) {
        if (script == null) {
            return List.of();
        }

        return pattern.splitAsStream(script)
                .map(s -> removeComments(s))
                .map(s -> s.trim())
                .filter(s -> s.length() > 0)
                .toList();
    }

    private String removeComments(String s) {
        return s.split("//")[0];
    }
}
