package com.wipro.vamos.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.model.Subscriber;
import com.wipro.vamos.repository.SubscriberRepository;

@Service
public class SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	public List<Subscriber> getAllSubscriber() {
		return subscriberRepository.findAll();
	}

	public Subscriber getSubscriberByID(long gnb_id) throws ResourceNotFoundException {
		return subscriberRepository.findById(gnb_id)
				.orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + gnb_id));
	}

	public List<Subscriber> getSubscriberByNodeID(String node_id) throws ResourceNotFoundException {
		return subscriberRepository.findAllByNodeId(node_id);
	}

	public Map<String, Long> getSubscriberStatusCountByNodeId(String node_id) {
		List<Subscriber> subscriberList = subscriberRepository.findAllByNodeId(node_id);
		Map<String, Long> readers = subscriberList.stream()
				.collect(Collectors.groupingBy(Subscriber::getStatus, Collectors.counting()));
		return readers;
	}

}
