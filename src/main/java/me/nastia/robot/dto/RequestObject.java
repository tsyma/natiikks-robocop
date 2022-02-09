package me.nastia.robot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.nastia.robot.position.Position;

@Getter
@Setter
@AllArgsConstructor
public class RequestObject {
    private String script;
    private Position position;
}
