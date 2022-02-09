package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionCommandTest {
    PositionCommand positionCommand;

    @BeforeEach
    void setUp() {
        positionCommand = new PositionCommand();
    }

    @Test
    void shouldReturnNewPosition() {
        Position result = positionCommand.run(new Position(0, 0, Direction.NORTH), List.of("4", "3", "WEST"));
        assertThat(result).isEqualTo(new Position(4, 3, Direction.WEST));
    }

}