package com.wipro.vamos.websocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vamos.model.Throughput;
import com.wipro.vamos.websocket.service.MessageService;

@RestController
@RequestMapping("/api/ws")
public class WebsocketController {

	@Autowired
	MessageService messageService;

	@PostMapping("throughput")
	public ResponseEntity<String> sendThroughput(@RequestBody List<Throughput> throughputs) {
		messageService.processAnsSendMessage(throughputs.toString());
		return ResponseEntity.ok("Throuhput Data Send to Client");
	}

	@PostMapping("alarm")
	public ResponseEntity<String> sendAlarm(@RequestBody List<Throughput> alarms) {
		messageService.processAnsSendMessage(alarms.toString());
		return ResponseEntity.ok("Alarm Data Send to Client");
	}

	@PostMapping("subscriber")
	public ResponseEntity<String> sendSubscriber(@RequestBody List<Throughput> subscribers) {
		messageService.processAnsSendMessage(subscribers.toString());
		return ResponseEntity.ok("Subscriber Data Send to Client");
	}

	@PostMapping("gnodeb")
	public ResponseEntity<String> sendGnodeb(@RequestBody List<Throughput> gNodeBs) {
		messageService.processAnsSendMessage(gNodeBs.toString());
		return ResponseEntity.ok("GNodeB Data Send to Client");
	}

	@MessageMapping("/msg")
	@SendTo("/topic/message")
	@PostMapping("message")
	public String send(String message) throws Exception {
		return message;
	}
}
