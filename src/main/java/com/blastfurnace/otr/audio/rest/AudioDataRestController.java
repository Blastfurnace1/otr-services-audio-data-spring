package com.blastfurnace.otr.audio.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blastfurnace.otr.audio.adapter.AudioDataAdapter;
import com.blastfurnace.otr.data.audiofile.model.AudioFileProperties;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.service.payload.PayloadWithCount;
import com.blastfurnace.otr.service.response.GenericResponse;

@RestController
@RequestMapping("/rest")
public class AudioDataRestController {

	@Autowired
	private AudioDataAdapter audioAdapter;

    @RequestMapping(value = "/get/{id:[\\d]+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GenericResponse<AudioFileProperties>>  get(@PathVariable long  id) {
    	GenericResponse<AudioFileProperties> g = audioAdapter.get(id);
    	ResponseEntity<GenericResponse<AudioFileProperties>> response = new ResponseEntity<GenericResponse<AudioFileProperties>>(g, HttpStatus.OK);
    	return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GenericResponse<PayloadWithCount<List<Map<String, Object>>>>>> query(@RequestParam Map<String, String> queryParameters) {

    	QueryData qry = new QueryData(queryParameters);
    	qry.setSort("title");
    	GenericResponse<PayloadWithCount<List<Map<String, Object>>>> g = audioAdapter.queryWithCount(qry);
    	
    	List<GenericResponse<PayloadWithCount<List<Map<String, Object>>>>> list = new ArrayList<GenericResponse<PayloadWithCount<List<Map<String, Object>>>>>();
    	list.add(g);
    	ResponseEntity<List<GenericResponse<PayloadWithCount<List<Map<String, Object>>>>>> response = new ResponseEntity<List<GenericResponse<PayloadWithCount<List<Map<String, Object>>>>>>(list, HttpStatus.OK);

    	return response;
    }
     
    @RequestMapping(value = "/delete/{id:[\\d]+}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<GenericResponse<String>> delete(@PathVariable long  id) {
    	
    	GenericResponse<String> g = audioAdapter.delete(id);
    	ResponseEntity<GenericResponse<String>> response = new ResponseEntity<GenericResponse<String>>(g, HttpStatus.OK);

    	return response;
    }
    
    @RequestMapping(value = "/resultsCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GenericResponse<Long>> getResultsCount(@RequestParam Map<String, String> queryParameters) {
    	 QueryData qry = new QueryData(queryParameters);
    	 GenericResponse<Long> g = audioAdapter.getResultsCount(qry);
    	return new ResponseEntity<GenericResponse<Long>>(g, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<GenericResponse<AudioFileProperties>> save(AudioFileProperties audio) {
    	GenericResponse<AudioFileProperties> g = audioAdapter.save(audio);
    	ResponseEntity<GenericResponse<AudioFileProperties>> response = new ResponseEntity<GenericResponse<AudioFileProperties>>(g, HttpStatus.OK);
    	return response;
    }

}
