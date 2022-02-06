package me.nastia.robot.commands;

import me.nastia.robot.Direction;
import me.nastia.robot.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WaitCommandTest {
    WaitCommand waitCommand;

    @BeforeEach
    void setup() {
        waitCommand = new WaitCommand();
    }

    @Test
    void shouldReturnWAIT() {
        assertThat(waitCommand.getName()).isEqualTo("WAIT");
    }

    @Test
    void shouldReturnSamePosition() {
        Position currentPosition = new Position(0, 0, Direction.NORTH);
        assertEquals(currentPosition,waitCommand.run(currentPosition, List.of("")));
    }
}