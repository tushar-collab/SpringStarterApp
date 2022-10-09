package com.io.springStarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.io.springStarter.model.Topic;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hello")
	public String sayHi() {
		System.out.println("hi");
		return "hi";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getTopics(){
		System.out.println("in controller");
		return helloService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return helloService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		String res = helloService.addTopic(topic);
		return res;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		helloService.updateTopic(topic,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public String deleteTopic(@PathVariable String id) {
		String status = helloService.deleteTopic(id);
		return status;
	}
}
