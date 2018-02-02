package edu.northeastern.cs5200.controllers.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {
	
	@Autowired
	HelloRepository helloRepo;
	
	@RequestMapping("/api/hello/string")
	public String sayHello() {
		return "Hello Amit Mangotra!";
	}
	
	@RequestMapping("/api/hello/object")
	public HelloObject sayHelloObject() {
		HelloObject ob = new HelloObject("Hello Amit Mangotra!");
		return ob;
	}
	
	@RequestMapping("/api/hello/insert")
	public HelloObject insertHelloObject() {
		HelloObject obj = new HelloObject("Hello Amit Mangotra!");
		helloRepo.save(obj);
		return obj;
	}
	
	@RequestMapping("/api/hello/insert/{msg}")
	public HelloObject insertessage(@PathVariable("msg") String message) {
		HelloObject obj = new HelloObject(message);
		helloRepo.save(obj);
		return obj;
	}
	
	@RequestMapping("/api/hello/select/all")
	public List<HelloObject> selectAllHelloObjects() {
		List<HelloObject> hellos = (List<HelloObject>) helloRepo.findAll();
		return hellos;
	}
}
