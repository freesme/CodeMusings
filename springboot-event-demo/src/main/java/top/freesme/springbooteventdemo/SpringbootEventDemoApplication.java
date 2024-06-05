package top.freesme.springbooteventdemo;

import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import top.freesme.springbooteventdemo.service.CustomerService;

@EnableAsync
@RestController
@SpringBootApplication
public class SpringbootEventDemoApplication {

	@Resource
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEventDemoApplication.class, args);
	}

	@GetMapping("/test/{param}")
	public String test(@PathVariable String param) {
		customerService.publishEvent(param);
		return "success";
	}

}
