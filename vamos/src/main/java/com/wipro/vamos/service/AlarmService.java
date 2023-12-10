package com.wipro.vamos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.vamos.exception.ResourceNotFoundException;
import com.wipro.vamos.model.Alarm;
import com.wipro.vamos.repository.AlarmRepository;
import com.wipro.vamos.response.AlarmResponse;

@Service
public class AlarmService {

	@Autowired
	AlarmRepository alarmRepository;

	public List<Alarm> getAllGnodeBs() {
		return alarmRepository.findAll();
	}

	public Alarm getAlarmByID(long alarm_id) throws ResourceNotFoundException {
		return alarmRepository.findById(alarm_id)
				.orElseThrow(() -> new ResourceNotFoundException("Alarm not found for this id :: " + alarm_id));
	}

	public List<Alarm> getAlarmByNodeID(String node_id) throws ResourceNotFoundException {
		return alarmRepository.findAllByNodeId(node_id);
	}

	public AlarmResponse getAlarmCountByNodeId(String node_id) {
		List<Alarm> alarms = alarmRepository.findAllByNodeId(node_id);
		AlarmResponse alarmResponse = new AlarmResponse();
		Map<String, Map<String, Long>> alarmCountByStatusandSeverity = new HashMap<String, Map<String, Long>>();
		Map<String, Long> statusMap = alarms.stream()
				.collect(Collectors.groupingBy(Alarm::getSeverity, Collectors.counting()));
		alarmCountByStatusandSeverity.put("Open", statusMap);
		alarmCountByStatusandSeverity.put("Closed", statusMap);
		alarmResponse.setAlarmCountByStatusandSeverity(alarmCountByStatusandSeverity);
		return alarmResponse;
	}

}
