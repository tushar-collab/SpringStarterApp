package com.io.springStarter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.io.springStarter.model.Topic;

@Service
public class HelloService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("top1","hi"),
			new Topic("top2","hi ji"),
			new Topic("top 3","gaand marao ji")
			)
			);
	
	public List<Topic> getTopics() {
		System.out.println("in service");
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getName().equals(id)).findFirst().get();
	}
	
	public String addTopic(Topic topic) {
		try {
			topics.add(topic);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void updateTopic(Topic topic, String id) {
		for(int i =0; i<topics.size();i++) {
			if(topics.get(i).getName().equals(id)) {
				topics.set(i, topic);
			}
		}
	}

	public String deleteTopic(String id) {
		String status = "fail";
		try {
			for(int i =0;i<topics.size();i++) {
				if(topics.get(i).getName().equals(id)) {
					topics.remove(i);
					status = "success";
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
