package me.nastia.robot.commands;

import me.nastia.robot.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForwardCommand implements Command {
    @Override
    public Position run(Position position, List<String> parameters) {
        return position; //TODO
    }

    @Override
    public String getName() {
        return "FORWARD";
    }
}
