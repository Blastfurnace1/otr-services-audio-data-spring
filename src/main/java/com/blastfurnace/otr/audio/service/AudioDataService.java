package com.blastfurnace.otr.audio.service;

import java.util.List;
import java.util.Map;

import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.service.payload.PayloadWithCount;
import com.blastfurnace.otr.service.request.QueryData;
import com.blastfurnace.otr.service.response.GenericServiceResponse;

public interface AudioDataService {

	GenericServiceResponse<PayloadWithCount<List<Map<String, Object>>>> queryWithCount(QueryData qry);

	GenericServiceResponse<Long> getResultsCount(QueryData qry);

	GenericServiceResponse<String> delete(Long id);

	GenericServiceResponse<AudioFileProperties> save(AudioFileProperties audio);

	GenericServiceResponse<AudioFileProperties> get(Long id);

	GenericServiceResponse<List<Map<String, Object>>> query(QueryData qry);

	GenericServiceResponse<AudioFileProperties> update(AudioFileProperties audio);	
}
