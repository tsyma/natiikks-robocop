package me.nastia.robot.commands;

import me.nastia.robot.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaitCommand implements Command{
    @Override
    public Position run(Position position, List<String> parameters) {
        return position;
    }

    @Override
    public String getName() {
        return "WAIT";
    }
}
