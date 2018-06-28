package com.blastfurnace.otr.audio.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.audio.service.AudioDataService;
import com.blastfurnace.otr.data.audiofile.AudioService;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.service.GenericService;
import com.blastfurnace.otr.service.payload.PayloadWithCount;
import com.blastfurnace.otr.service.response.GenericResponse;

@Component("AudioDataService")
public class AudioDataServiceImpl implements AudioDataService {
	
	@Autowired
	private AudioService service;
	
	private GenericService<AudioFileProperties> gService;

	public AudioDataServiceImpl() {
		gService = new GenericService<AudioFileProperties>(AudioFileProperties.fieldDefinitions);
	}
	
	@Override
	public GenericResponse<List<Map<String,Object>>> query(QueryData qry) {
		return gService.query(qry, service);
	}

	@Override
	public GenericResponse<PayloadWithCount<List<Map<String,Object>>>> queryWithCount(QueryData qry) {
		return gService.queryWithCount(qry, service);
	}
	
	@Override
	public GenericResponse<AudioFileProperties> get(Long id) {
		return gService.get(id, service);
	}

	
	@Override
	public GenericResponse<Long> getResultsCount(QueryData qry) {
		return gService.getResultsCount(qry, service);
	}

	@Override
	public GenericResponse<String> delete(Long id) {
		return gService.delete(id, service);
	}

	@Override
	public GenericResponse<AudioFileProperties> save(AudioFileProperties audio) {
		return gService.save(audio, service);
	}
	
	
	@Override
	public GenericResponse<AudioFileProperties> update(AudioFileProperties audio) {
		GenericResponse<AudioFileProperties> response = new GenericResponse<AudioFileProperties>(null);
		if (audio == null) {
			response.setStatus(-50l);
			response.setMessage("Unable to update Record - nothing to update");
		}
		try {	
			AudioFileProperties newAudio = service.get(audio.getId());
			newAudio.updateAudioFile(audio);
			newAudio = service.save(newAudio);
			response.setPayload(newAudio);
			if (newAudio == null) {
				response.setStatus(-50l);
				response.setMessage("Unable to update Record");
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}
}
