
package com.blastfurnace.otr.audio;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blastfurnace.otr.AppConfigTest;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertTrue;

/**
 * Integration Tests for Audio Services
 *
 * @author Jim Blackson*/
public class AudioServiceApplicationTests extends AppConfigTest {

	private static final Logger log = LoggerFactory.getLogger(AudioServiceApplicationTests.class); 
	
	@Test
	public void shouldPerformAudioServiceTests() throws Exception {
		log.info("Audio Service Tests - Start");

		log.info("Audio Service Tests - End");
	}
	
}
