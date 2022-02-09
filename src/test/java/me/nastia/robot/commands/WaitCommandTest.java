package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaitCommandTest {
    WaitCommand waitCommand;

    @BeforeEach
    void setup() {
        waitCommand = new WaitCommand();
    }

    @Test
    void shouldReturnSamePosition() {
        Position currentPosition = new Position(0, 0, Direction.NORTH);
        assertEquals(currentPosition, waitCommand.run(currentPosition, List.of("")));
    }
}