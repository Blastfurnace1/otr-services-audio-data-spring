package com.blastfurnace.otr.rest.adapter;

import java.util.List;
import java.util.Map;

import com.blastfurnace.otr.model.AudioFileProperties;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.rest.response.GenericRestResponse;
public interface AudioDataAdapter {

	GenericRestResponse<AudioFileProperties> get(Long id);

	GenericRestResponse<List<Map<String, Object>>> query(QueryData qry);

	GenericRestResponse<Long> getResultsCount(QueryData qry);

	GenericRestResponse<String> delete(Long id);

	GenericRestResponse<AudioFileProperties> save(AudioFileProperties audio);

}