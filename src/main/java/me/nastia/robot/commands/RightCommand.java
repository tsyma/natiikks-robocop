package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RightCommand implements Command {
    @Override
    public Position run(Position position, List<String> parameters) {
        switch (position.getDirection()) {
            case EAST -> position.setDirection(Direction.SOUTH);
            case WEST -> position.setDirection(Direction.NORTH);
            case NORTH -> position.setDirection(Direction.EAST);
            case SOUTH -> position.setDirection(Direction.WEST);
        }
        return position;
    }
}
