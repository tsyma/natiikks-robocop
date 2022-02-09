package me.nastia.robot.commands;

import me.nastia.robot.position.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForwardCommand implements Command {
// FORWARD 3

    @Override
    public Position run(Position position, List<String> parameters) {
        switch (position.getDirection()) {
            case EAST -> {
                position.setX(position.getX() + Integer.parseInt(parameters.get(0)));
            }
            case WEST -> {
                position.setX(position.getX() - Integer.parseInt(parameters.get(0)));
            }
            case NORTH -> {
                position.setY(position.getY() - Integer.parseInt(parameters.get(0)));
            }
            case SOUTH -> {
                position.setY(position.getY() + Integer.parseInt(parameters.get(0)));
            }
        }
        return position;
    }

}
