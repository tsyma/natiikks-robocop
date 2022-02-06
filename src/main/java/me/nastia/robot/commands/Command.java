package me.nastia.robot.commands;

import me.nastia.robot.Position;
import java.util.List;

public interface Command {

    Position run(Position position, List<String> parameters);

    String getName();
}
