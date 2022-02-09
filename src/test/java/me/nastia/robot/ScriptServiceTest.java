package me.nastia.robot;

import me.nastia.robot.commands.Command;
import me.nastia.robot.position.Direction;
import me.nastia.robot.position.Position;
import me.nastia.robot.services.ParseService;
import me.nastia.robot.services.ScriptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class ScriptServiceTest {
    ScriptService scriptService;
    Map<String, Command> commandMap;

    @Mock
    ParseService parseService;

    @BeforeEach
    void setUp() {
        scriptService = new ScriptService(parseService, commandMap);
    }

    @Test
    void shouldReturnPosition() {
        Position execute = scriptService.execute("", new Position(0, 0, Direction.EAST));
        assertNotNull(execute);
    }

    @Test
    void shouldCallParseMethod() {
        Position execute = scriptService.execute("nnnn", new Position(0, 0, Direction.EAST));
        verify(parseService).parse("nnnn");
    }

}