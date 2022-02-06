package me.nastia.robot;

import me.nastia.robot.commands.Command;
import me.nastia.robot.services.ParseService;
import me.nastia.robot.services.ScriptService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;


@SpringBootApplication
public class RobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class, args);
        new ScriptService(new ParseService(), new HashMap<String, Command>()).execute("POSITION 1 3 EAST //sets the initial position for the robot as x, y.\n" +
                "FORWARD 3 //lets the robot do 3 steps forward\n" +
                "WAIT //lets the robot do nothing",new Position(0,0,Direction.NORTH));
    }
}
