package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightCommandTest {
    RightCommand rightCommand;

    @BeforeEach
    void setUp() {
        rightCommand = new RightCommand();
    }

    @Test
    void shouldTurnToNorth() {
        Position result = rightCommand.run(new Position(0, 0, Direction.WEST), List.of(""));
        assertEquals(new Position(0, 0, Direction.NORTH), result);
    }

    @Test
    void shouldTurnToEast() {
        Position result = rightCommand.run(new Position(0, 0, Direction.NORTH), List.of(""));
        assertEquals(new Position(0, 0, Direction.EAST), result);
    }

    @Test
    void shouldTurnToSouth() {
        Position result = rightCommand.run(new Position(0, 0, Direction.EAST), List.of(""));
        assertEquals(new Position(0, 0, Direction.SOUTH), result);
    }

    @Test
    void shouldTurnToWest() {
        Position result = rightCommand.run(new Position(0, 0, Direction.SOUTH), List.of(""));
        assertEquals(new Position(0, 0, Direction.WEST), result);
    }
}