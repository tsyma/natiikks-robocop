package me.nastia.robot.commands;

import me.nastia.robot.Direction;
import me.nastia.robot.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionCommand implements Command {
    //POSITION 1 3 EAST

    @Override
    public Position run(Position position, List<String> parameters) {
        return new Position(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)), Direction.valueOf(parameters.get(2)));
    }

    @Override
    public String getName() {
        return "POSITION";
    }
}
