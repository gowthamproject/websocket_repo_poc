package com.wipro.vamos.websocket.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.wipro.vamos.response.ThroughputResponse;
import com.wipro.vamos.service.GNodeBService;
import com.wipro.vamos.service.ThrouhputService;

@Service
public class MessageService {

	@Autowired
	GNodeBService gNodeBService;

	@Autowired
	ThrouhputService throuhputService;

	@Autowired
	public SimpMessageSendingOperations messagingTemplate;

	public void processAndSendMessage_GNodeB(String node_id) {
		Map<String, Long> gNodeBStatusCount = gNodeBService.getGNodeBStatusCountByNodeId(node_id);
		System.out.println("Sending message to client -- /topic/gnodeb : " + gNodeBStatusCount);
		messagingTemplate.convertAndSend("/topic/gnodeb", gNodeBStatusCount);
	}

	public void processAndSendMessage_Throughput(String node_id) {
		ThroughputResponse throughputResponse = throuhputService.getThrouhputByNodeId(node_id);
		System.out.println("Sending message to client -- /topic/throuhput : " + throughputResponse.toString());
		messagingTemplate.convertAndSend("/topic/throuhput", throughputResponse);
	}
	
	public void processAndSendMessage_Subscriber(String node_id) {
		ThroughputResponse throughputResponse = throuhputService.getThrouhputByNodeId(node_id);
		System.out.println("Sending message to client -- /topic/subscriber : " + throughputResponse.toString());
		messagingTemplate.convertAndSend("/topic/subscriber", throughputResponse);
	}
	
	public void processAndSendMessage_PDUSession(String node_id) {
		ThroughputResponse throughputResponse = throuhputService.getThrouhputByNodeId(node_id);
		System.out.println("Sending message to client -- /topic/pdusession : " + throughputResponse.toString());
		messagingTemplate.convertAndSend("/topic/pdusession", throughputResponse);
	}
	
	public void processAndSendMessage_Alarm(String node_id) {
		ThroughputResponse throughputResponse = throuhputService.getThrouhputByNodeId(node_id);
		System.out.println("Sending message to client -- /topic/alarm : " + throughputResponse.toString());
		messagingTemplate.convertAndSend("/topic/alarm", throughputResponse);
	}
	
}