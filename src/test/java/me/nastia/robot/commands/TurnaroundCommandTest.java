package me.nastia.robot.commands;

import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TurnaroundCommandTest {

    TurnaroundCommand turnroundCommand;

    @BeforeEach
    void setUp() {
        turnroundCommand = new TurnaroundCommand();
    }

    @Test
    void shouldReturnNotNull() {
        Position result = turnroundCommand.run(new Position(0, 0, Direction.NORTH), List.of(""));
        assertThat(result).isNotNull();
    }

    @Test
    void shouldRotateNorthToSouth() {
        Position result = turnroundCommand.run(new Position(0, 0, Direction.NORTH), List.of(""));
        assertThat(result).isEqualTo(new Position(0, 0, Direction.SOUTH));
    }

    @Test
    void shouldRotateSouthToNorth() {
        Position result = turnroundCommand.run(new Position(0, 0, Direction.SOUTH), List.of(""));
        assertThat(result).isEqualTo(new Position(0, 0, Direction.NORTH));
    }

    @Test
    void shouldRotateWestToEast() {
        Position result = turnroundCommand.run(new Position(0, 0, Direction.WEST), List.of(""));
        assertThat(result).isEqualTo(new Position(0, 0, Direction.EAST));
    }

    @Test
    void shouldRotateEastToWest() {
        Position result = turnroundCommand.run(new Position(0, 0, Direction.EAST), List.of(""));
        assertThat(result).isEqualTo(new Position(0, 0, Direction.WEST));
    }
}