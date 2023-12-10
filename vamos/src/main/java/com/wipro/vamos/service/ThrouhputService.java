package com.wipro.vamos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.vamos.model.Throughput;
import com.wipro.vamos.repository.ThroughputRepository;
import com.wipro.vamos.response.ThroughputResponse;

@Service
public class ThrouhputService {
	@Autowired
	ThroughputRepository throughputRepository;

	public ThroughputResponse getThrouhputByNodeId(String node_id) {
		List<Throughput> troughputs = throughputRepository.findAllByNodeId(node_id);
		ThroughputResponse response = new ThroughputResponse();
		response.setUplink(troughputs.get(0).getUplink());
		response.setDownlink(troughputs.get(0).getDownlink());
		response.setUpdate_time(troughputs.get(0).getUpdated_time());
		return response;
	}

}
