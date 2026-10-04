package dio.primeiros_passos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    private String msg = "Hello World";

    public HelloController(String msg){
        this.msg = msg;
    }

    public HelloController() {
    }



    @GetMapping("/hello")
    public String getMsg(){
        return this.msg;
    }


   

}
