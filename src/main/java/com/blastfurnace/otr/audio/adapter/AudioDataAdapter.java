package com.blastfurnace.otr.audio.adapter;

import java.util.List;
import java.util.Map;

import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.service.payload.PayloadWithCount;
import com.blastfurnace.otr.service.response.GenericResponse;

public interface AudioDataAdapter {

	GenericResponse<AudioFileProperties> get(Long id);

	GenericResponse<List<Map<String, Object>>> query(QueryData qry);

	GenericResponse<Long> getResultsCount(QueryData qry);

	GenericResponse<String> delete(Long id);

	GenericResponse<AudioFileProperties> save(AudioFileProperties audio);

	GenericResponse<PayloadWithCount<List<Map<String, Object>>>> queryWithCount(QueryData qry);
}