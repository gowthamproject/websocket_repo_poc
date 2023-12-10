package com.wipro.vamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.response.ThroughputResponse;
import com.wipro.vamos.service.ThrouhputService;

@RestController
@RequestMapping("/api/v1")
public class ThroughputController {

	@Autowired
	ThrouhputService throuhputService;

	@GetMapping(value = "/throuhput/nodes/{node_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ThroughputResponse getThroughputByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return throuhputService.getThrouhputByNodeId(node_id);
	}
}
