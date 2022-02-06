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
        new ScriptService(new ParseService(), new HashMap<String, Command>());
    }
}
