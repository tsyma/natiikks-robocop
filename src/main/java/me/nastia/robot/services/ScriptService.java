package me.nastia.robot.services;

import me.nastia.robot.commands.Command;
import me.nastia.robot.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class ScriptService {
    private final ParseService parseService;
    private final Map<String, Command> map;

    public ScriptService(ParseService parseService, @Autowired Map<String, Command> map) {
        this.parseService = parseService;
        this.map = map;
    }

    public Position execute(String script, Position position) {
        List<String> commands = parseService.parse(script);
        for (String command : commands) {
            String[] components = command.split("\\s+");
            position = map.get(components[0].toLowerCase() + "Command").run(position, getParams(components));
        }
        return position;
    }

    private List<String> getParams(String[] components) {
        return Arrays.asList(Arrays.copyOfRange(components, 1, components.length));
    }

}