package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ForwardCommandTest {
    ForwardCommand forwardCommand;

    @BeforeEach
    void setup() {
        forwardCommand = new ForwardCommand();
    }

    @Test
    void shouldReturnPositionObject() {
        Position result = forwardCommand.run(new Position(0, 0, Direction.NORTH), List.of("3"));
        assertEquals(Position.class, result.getClass());
    }

    @Test
    void shouldMoveNorth() {
        Position result = forwardCommand.run(new Position(5, 5, Direction.NORTH), List.of("3"));
        assertThat(result).isEqualTo(new Position(5, 2, Direction.NORTH));
    }

    @Test
    void shouldMoveSouth() {
        Position result = forwardCommand.run(new Position(0, 0, Direction.SOUTH), List.of("3"));
        assertThat(result).isEqualTo(new Position(0, 3, Direction.SOUTH));
    }

    @Test
    void shouldMoveEast() {
        Position result = forwardCommand.run(new Position(0, 0, Direction.EAST), List.of("3"));
        assertThat(result).isEqualTo(new Position(3, 0, Direction.EAST));
    }

    @Test
    void shouldMoveWest() {
        Position result = forwardCommand.run(new Position(5, 5, Direction.WEST), List.of("3"));
        assertThat(result).isEqualTo(new Position(2, 5, Direction.WEST));
    }

}