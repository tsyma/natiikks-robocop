package me.nastia.robot.contollers;

import me.nastia.robot.dto.RequestObject;
import me.nastia.robot.position.Position;
import me.nastia.robot.services.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScriptController {
    private final ScriptService scriptService;

    public ScriptController(@Autowired ScriptService scriptService) {
        this.scriptService = scriptService;
    }

    @PostMapping("/execute")
    @ResponseBody
    public Position runScript(@RequestBody RequestObject requestObject) {
        return scriptService.execute(requestObject.getScript(), requestObject.getPosition());
    }

}
