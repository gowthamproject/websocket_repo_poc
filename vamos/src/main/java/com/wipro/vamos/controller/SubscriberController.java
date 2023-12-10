package com.wipro.vamos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.model.Subscriber;
import com.wipro.vamos.service.SubscriberService;

@RestController
@RequestMapping("/api/v1")
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberRepository;

	@GetMapping("/subscriber")
	public ResponseEntity<List<Subscriber>> getAllSubscriber() throws ResourceNotFoundException {
		return ResponseEntity.ok(subscriberRepository.getAllSubscriber());
	}

	@GetMapping("/subscriber/{subscriber_id}")
	public ResponseEntity<Subscriber> getAllSubscriberById(@PathVariable(value = "subscriber_id") long subscriber_id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(subscriberRepository.getSubscriberByID(subscriber_id));
	}

	@GetMapping("/subscriber/nodes/{node_id}")
	public ResponseEntity<List<Subscriber>> getAllSubscriberByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(subscriberRepository.getSubscriberByNodeID(node_id));
	}

	@GetMapping("/subscriber/status/count/{node_id}")
	public Map<String, Long> getSubscriberStatusCountByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return subscriberRepository.getSubscriberStatusCountByNodeId(node_id);
	}

}
