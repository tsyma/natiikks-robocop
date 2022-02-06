package me.nastia.robot;

import me.nastia.robot.services.ParseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParseServiceTest {
    ParseService parseService;

    @BeforeEach
    void setUp() {
        parseService = new ParseService();
    }

    @Test
    void shouldReturnEmptyListForEmptyScript() {
        List<String> result = parseService.parse("");
        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnOneCommandList() {
        List<String> result = parseService.parse("POSITION 1 3 EAST");
        assertThat(result).isEqualTo(List.of("POSITION 1 3 EAST"));
    }

    @Test
    void shouldReturnTwoCommandsList() {
        List<String> result = parseService.parse("POSITION 1 3 EAST\n FORWARD 3");
        assertThat(result).isEqualTo(List.of("POSITION 1 3 EAST", "FORWARD 3"));
    }

    @Test
    void shouldReturnCommandsListWithoutComments() {
        List<String> result = parseService.parse("\n POSITION 1 3 EAST //sets the initial position for the robot as x, y." +
                "\n FORWARD 3 //lets the robot do 3 steps forward\n\n\n");
        assertThat(result).isEqualTo(List.of("POSITION 1 3 EAST", "FORWARD 3"));
    }

    @Test
    void shouldReturnEmptyListForNull() {
        List<String> result = parseService.parse(null);
        assertThat(result).isEmpty();
    }

}