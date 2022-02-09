package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnaroundCommand implements Command {
//    TURNAROUND

    @Override
    public Position run(Position position, List<String> parameters) {
        switch (position.getDirection()) {
            case EAST -> position.setDirection(Direction.WEST);
            case WEST -> position.setDirection(Direction.EAST);
            case NORTH -> position.setDirection(Direction.SOUTH);
            case SOUTH -> position.setDirection(Direction.NORTH);
        }
        return position;
    }
}
