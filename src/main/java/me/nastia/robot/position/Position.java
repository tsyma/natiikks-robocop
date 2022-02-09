package me.nastia.robot.position;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Position {
    int x;
    int y;
    Direction direction;
}
