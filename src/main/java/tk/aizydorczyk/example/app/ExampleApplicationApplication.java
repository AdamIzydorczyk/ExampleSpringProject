package tk.aizydorczyk.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication(scanBasePackages = "tk.aizydorczyk.example", scanBasePackageClasses = ExampleApplicationApplication.TestController.class)
public class ExampleApplicationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplicationApplication.class, args);
    }

    @RestController
    @RequestMapping(value = "test")
    public static class TestController{
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public FooDto create(@RequestBody FooDto dto,
                              HttpServletRequest request) {
            return dto;
        }
    }

    public static class FooDto{
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
