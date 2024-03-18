package ro.sda.java64.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class RestControllerExample {

    @RequestMapping("/hello")
    public @ResponseBody String helloMessage(@RequestParam(required = false,value = "nume") String name){
        return "Hello" + name;
    }

    @RequestMapping("/hello/nume/{value}")
    public @ResponseBody String helloPathVariableMessage(@PathVariable String value){
        return "Hello pathVariable" + value;
    }

    @RequestMapping("/hello/prenume/{value}")
    public ResponseEntity<String> helloResponseEntityMessage(@PathVariable String value){
        return ResponseEntity.ok("Hello pathVariable" + value);
    }

//    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    @PostMapping("/hello2")
    public ResponseEntity hello2(@RequestBody ResponseObject input){
        System.out.println("Hello using request body :" + input.getName() + " / " + input.getLastName());
        return ResponseEntity.ok().build();
    }
}
