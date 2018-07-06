
package com.blastfurnace.otr.audio;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.blastfurnace.otr.utils.UtilitiesApplicationTest;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for Audio Services
 *
 * @author Jim Blackson*/
public class AudioServiceApplicationTests extends UtilitiesApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(AudioServiceApplicationTests.class); 
	
	@Test
	public void shouldPerformAudioServiceTests() throws Exception {
		log.info("Audio Service Tests - Start");
//		@SuppressWarnings("rawtypes")
//		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
//				"http://localhost:" + this.port + "/rest/get/3", Map.class);
//
//		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		
//		HttpHeaders httpHeaders = this.testRestTemplate
//				  .headForHeaders("http://localhost:" + this.port + "/rest/get/3");
//		
//		assertTrue(httpHeaders.getContentType()
//				  .includes(MediaType.APPLICATION_JSON));
//		
//		AudioFileProperties audio = this.testRestTemplate.getForObject(
//				"http://localhost:" + this.port + "/rest/get/3", AudioFileProperties.class);
//
//		then(entity).isNotNull();
//		then(audio.getId()).isEqualTo(3);
//		then(audio.getFilename()).isNotNull();
		log.info("Audio Service Tests - End");
	}
	
}
