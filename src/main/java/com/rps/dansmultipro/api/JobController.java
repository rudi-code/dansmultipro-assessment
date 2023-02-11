/**
 * 
 */
package com.rps.dansmultipro.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rps.dansmultipro.domain.User;

import lombok.RequiredArgsConstructor;

/**
 * @author rudi_ Feb 11, 2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JobController {

	@GetMapping("/jobs")
	public ResponseEntity<List<Map>> getJobs() {

		List<Map> result = new ArrayList<>();

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";

		List<Map> request = restTemplate.getForObject(url, List.class);
		for (Map map : request) {
			Map m = new HashMap<>();
			m.put("id", map.get("id"));
			m.put("title", map.get("title"));
			result.add(m);
		}
		return new ResponseEntity<List<Map>>(result, HttpStatus.OK);
	}

	@GetMapping("/job-detail/{id}")
	public ResponseEntity<Map> getJobDetail(@PathVariable String id) {

		List<Map> result = new ArrayList<>();

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id;

		Map request = restTemplate.getForObject(url, Map.class);
		return new ResponseEntity<Map>(request, HttpStatus.OK);
	}

}
