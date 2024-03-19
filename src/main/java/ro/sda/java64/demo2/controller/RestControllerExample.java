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

    @RequestMapping("/hello/prenume/{value9}/{value1}/{value2}")
    public ResponseEntity<String> helloResponseEntityMessage(@PathVariable(name="value9") String value,@PathVariable String value2){
        return ResponseEntity.ok("Hello pathVariable" + value);
    }

//    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    @PostMapping("/hello2")
    public ResponseEntity<String> hello2(@RequestBody ResponseObject input){
        String value="Hello using request body :" + input.getName() + " / " + input.getLastName();
        System.out.println(value);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> hello2_get(@RequestBody ResponseObject input){
        String value="Hello using request body :" + input.getName() + " / " + input.getLastName();
        System.out.println(value);
        return ResponseEntity.ok(value);
    }
}
