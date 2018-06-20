package com.blastfurnace.otr.rest.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.model.AudioFileProperties;
import com.blastfurnace.otr.reflection.ObjectData;
import com.blastfurnace.otr.reflection.Utils;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.rest.response.GenericRestResponse;
import com.blastfurnace.otr.service.AudioService;


@Component("AudioDataAdapter")
public class AudioDataAdapterImpl implements AudioDataAdapter {

	@Autowired
	private AudioService service;
	
	@Override
	public GenericRestResponse<AudioFileProperties> get(Long id) {
		GenericRestResponse<AudioFileProperties> response = new GenericRestResponse<AudioFileProperties>(null);
		try {
			AudioFileProperties audio = service.get(id);
			response.setPayload(audio);

			if (audio == null) {
				response.setStatus(10l);
				response.setMessage("No Results found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}


	@Override
	public GenericRestResponse<List<Map<String,Object>>> query(QueryData qry) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		GenericRestResponse<List<Map<String,Object>>> response = new GenericRestResponse<List<Map<String,Object>>>(list);
		try {
			String[] columns = Utils.getFields(qry);

			Iterable<AudioFileProperties> props = service.query(qry);

			if (props == null) {
				response.setStatus(10l);
				response.setMessage("No Results found");
			} else {
				for (AudioFileProperties afp : props) {
					ObjectData<AudioFileProperties> obj = new ObjectData<AudioFileProperties>(afp);
					Map<String,Object> map = null;
					try {
						map = obj.addValues(columns, AudioFileProperties.fieldDefinitions);
					} catch (Exception  e) {
						response.setErrorOccured(true);
						response.addError(e.getMessage());
					}
					list.add(map);
				}

				if (list.isEmpty() && response.getErrorOccured() == false) {
					response.setStatus(10l);
					response.setMessage("No Results found");
				}

				if (response.getErrorOccured()) {
					response.setStatus(-20l);
					response.setMessage("unable to get complete data");
				}
				response.setPayload(list);
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get results");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}
		return response;
	}

	
	@Override
	public GenericRestResponse<Long> getResultsCount(QueryData qry) {
		GenericRestResponse<Long> response = new GenericRestResponse<Long>(null);
		try {
			Long count = service.getResultsCount(qry);
			response.setPayload(count);
			if (count == null) {
				response.setStatus(-30l);
				response.setMessage("Unable to save Record");
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result count");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}

	@Override
	public GenericRestResponse<String> delete(Long  id) {

		GenericRestResponse<String> response = new GenericRestResponse<String>("");
		try {
			service.delete(id);
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to delete record");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}

	@Override
	public GenericRestResponse<AudioFileProperties> save(AudioFileProperties audio) {
		GenericRestResponse<AudioFileProperties> response = new GenericRestResponse<AudioFileProperties>(null);
		try {
			AudioFileProperties newAudio = service.save(audio);
			response.setPayload(newAudio);
			if (audio == null) {
				response.setStatus(-50l);
				response.setMessage("Unable to save Record");
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