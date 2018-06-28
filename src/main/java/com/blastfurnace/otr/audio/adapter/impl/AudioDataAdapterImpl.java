package com.blastfurnace.otr.audio.adapter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.audio.adapter.AudioDataAdapter;
import com.blastfurnace.otr.audio.service.AudioDataService;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.service.payload.PayloadWithCount;
import com.blastfurnace.otr.service.response.GenericResponse;


@Component("AudioDataAdapter")
public class AudioDataAdapterImpl implements AudioDataAdapter {

	@Autowired
	private AudioDataService service;
	
	@Override
	public GenericResponse<AudioFileProperties> get(Long id) {
		return service.get(id);
	}

	@Override
	public GenericResponse<PayloadWithCount<List<Map<String,Object>>>> queryWithCount(QueryData qry) {
		return service.queryWithCount(qry);
	}

	@Override
	public GenericResponse<List<Map<String,Object>>> query(QueryData qry) {
		return service.query(qry);
	}
	
	@Override
	public GenericResponse<Long> getResultsCount(QueryData qry) {
		return service.getResultsCount(qry);
	}

	@Override
	public GenericResponse<String> delete(Long  id) {
		return service.delete(id);
	}

	@Override
	public GenericResponse<AudioFileProperties> save(AudioFileProperties audio) {
		return service.save(audio);
	}
}
