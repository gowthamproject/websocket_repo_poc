package com.wipro.vamos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.model.Alarm;
import com.wipro.vamos.repository.AlarmRepository;
import com.wipro.vamos.response.AlarmResponse;
import com.wipro.vamos.service.AlarmService;

@RestController
@RequestMapping("/api/v1")
public class AlarmController {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AlarmController.class);

	@Autowired
	AlarmService alarmService;

	@GetMapping(value = "/alarm/{alarm_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Alarm> getAlarmById(@PathVariable(value = "alarm_id") long id)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(alarmService.getAlarmByID(id));
	}

	@GetMapping(value = "/alarm/nodes/{node_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Alarm> getAllAlarmByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return alarmService.getAlarmByNodeID(node_id);
	}

	@GetMapping(value = "/alarm/count/{node_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public AlarmResponse getAlarmCountByNodeId(@PathVariable(value = "node_id") String node_id)
			throws ResourceNotFoundException {
		return alarmService.getAlarmCountByNodeId(node_id);

	}

}
