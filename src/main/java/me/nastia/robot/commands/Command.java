package me.nastia.robot.commands;

import me.nastia.robot.position.Position;

import java.util.List;

public interface Command {

    Position run(Position position, List<String> parameters);

}
