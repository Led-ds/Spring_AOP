package com.br.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.empresa.domain.dto.RequestDTO;

@Service
public class SendMessageException {

	@Autowired
	private RestTemplate restTemplate;
	
	public void sendMessage(RequestDTO dto) {
		restTemplate.postForObject("URL", dto, RequestDTO.class);
	}
}
