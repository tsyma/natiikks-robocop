package me.nastia.robot.services;

import me.nastia.robot.Position;
import me.nastia.robot.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class ScriptService {
    private final ParseService parseService;
    private final Map<String, Command> map;

    @Autowired
    public ScriptService(ParseService parseService, Map<String, Command> map) {
        this.parseService = parseService;
        this.map = map;
    }

    Map<String, Command> commandMap;


    public Position execute(String script, Position position) {
        List<String> commands = parseService.parse(script);
        for (String command : commands) {
            String[] components = command.split("\\s+");
            position = commandMap.get(components[0]).run(position, getParams(components));
        }
        return position;
    }

    private List<String> getParams(String[] components) {
        return Arrays.asList(Arrays.copyOfRange(components, 1, components.length - 1));
    }

    @PostConstruct
    public void print() {
        for (String string : map.keySet()) {
            System.out.println(string + "+ " + map.get(string));
        }
    }
}