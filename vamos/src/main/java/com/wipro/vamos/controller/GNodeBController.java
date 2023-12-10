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
import com.wipro.vamos.model.GNodeB;
import com.wipro.vamos.service.GNodeBService;

@RestController
@RequestMapping("/api/v1")
public class GNodeBController {

	@Autowired
	GNodeBService gNodeBService;

	@GetMapping("/gNB")
	public ResponseEntity<List<GNodeB>> getAllGNodeB() throws ResourceNotFoundException {
		return ResponseEntity.ok(gNodeBService.getAllGnodeBs());
	}

	@GetMapping("/gNB/{gNB_id}")
	public ResponseEntity<GNodeB> getAllGNodeBById(@PathVariable(value = "gNB_id") long gnb_id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(gNodeBService.getGNodeBByID(gnb_id));
	}

	@GetMapping("/gNB/nodes/{node_id}")
	public ResponseEntity<List<GNodeB>> getAllGNodeBByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(gNodeBService.getGNodeBByNodeID(node_id));
	}

	@GetMapping("/gNB/status/count/{node_id}")
	public Map<String, Long> getGNodeBStatusCountByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return gNodeBService.getGNodeBStatusCountByNodeId(node_id);
	}

}
