package com.wipro.vamos.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.model.GNodeB;
import com.wipro.vamos.repository.GNodeBRepository;

@Service
public class GNodeBService {

	@Autowired
	private GNodeBRepository gNodeBRepository;

	public List<GNodeB> getAllGnodeBs() {
		return gNodeBRepository.findAll();
	}

	public GNodeB getGNodeBByID(long gnb_id) throws ResourceNotFoundException {
		return gNodeBRepository.findById(gnb_id)
				.orElseThrow(() -> new ResourceNotFoundException("gNB not found for this id :: " + gnb_id));
	}

	public List<GNodeB> getGNodeBByNodeID(String node_id) throws ResourceNotFoundException {
		return gNodeBRepository.findAllByNodeId(node_id);
	}

	public Map<String, Long> getGNodeBStatusCountByNodeId(String node_id) {
		List<GNodeB> gnbList = gNodeBRepository.findAllByNodeId(node_id);
		return gnbList.stream().collect(Collectors.groupingBy(GNodeB::getStatus, Collectors.counting()));
	}

}
