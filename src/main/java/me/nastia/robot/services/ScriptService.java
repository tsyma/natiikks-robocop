package me.nastia.robot.services;

import me.nastia.robot.Position;
import me.nastia.robot.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class ScriptService {
    private final ParseService parseService;
    private final Map<String, Command> commandMap;

    @Autowired
    public ScriptService(ParseService parseService, Map<String, Command> map) {
        this.parseService = parseService;
        this.commandMap = map;
    }


    public Position execute(String script, Position position) {
        List<String> commands = parseService.parse(script);
        for (String command : commands) {
            String[] components = command.split("\\s+");
            position = commandMap.get(components[0].toLowerCase() + "command").run(position, getParams(components));
        }
        return position;
    }

    private List<String> getParams(String[] components) {
        return Arrays.asList(Arrays.copyOfRange(components, 1, components.length - 1));
    }

//    @PostConstruct
//    public void print() {
//        for (String string : commandMap.keySet()) {
//            System.out.println(string + "+ " + commandMap.get(string));
//        }
//    }
}