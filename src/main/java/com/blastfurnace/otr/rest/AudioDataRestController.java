package com.blastfurnace.otr.rest;

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

import com.blastfurnace.otr.model.AudioFileProperties;
import com.blastfurnace.otr.rest.adapter.AudioDataAdapter;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.rest.response.GenericRestResponse;

@RestController
@RequestMapping("/rest")
public class AudioDataRestController {

	@Autowired
	private AudioDataAdapter audioAdapter;

    @RequestMapping(value = "/get/{id:[\\d]+}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GenericRestResponse<AudioFileProperties>>  get(@PathVariable long  id) {
    	GenericRestResponse<AudioFileProperties> g = audioAdapter.get(id);
    	ResponseEntity<GenericRestResponse<AudioFileProperties>> response = new ResponseEntity<GenericRestResponse<AudioFileProperties>>(g, HttpStatus.OK);
    	return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GenericRestResponse<List<Map<String, Object>>>>> query(@RequestParam Map<String, String> queryParameters) {

    	QueryData qry = new QueryData(queryParameters);
    	qry.setSort("title");
    	GenericRestResponse<List<Map<String,Object>>> g = audioAdapter.query(qry);
    	List<GenericRestResponse<List<Map<String, Object>>>> list = new ArrayList<GenericRestResponse<List<Map<String, Object>>>>();
    	list.add(g);
    	ResponseEntity<List<GenericRestResponse<List<Map<String, Object>>>>> response = new ResponseEntity<List<GenericRestResponse<List<Map<String, Object>>>>>(list, HttpStatus.OK);

    	return response;
    }
     
    @RequestMapping(value = "/delete/{id:[\\d]+}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<GenericRestResponse<String>> delete(@PathVariable long  id) {
    	
    	GenericRestResponse<String> g = audioAdapter.delete(id);
    	ResponseEntity<GenericRestResponse<String>> response = new ResponseEntity<GenericRestResponse<String>>(g, HttpStatus.OK);

    	return response;
    }
    
    @RequestMapping(value = "/resultsCount", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GenericRestResponse<Long>> getResultsCount(@RequestParam Map<String, String> queryParameters) {
    	 QueryData qry = new QueryData(queryParameters);
    	 GenericRestResponse<Long> g = audioAdapter.getResultsCount(qry);
    	return new ResponseEntity<GenericRestResponse<Long>>(g, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<GenericRestResponse<AudioFileProperties>> save(AudioFileProperties audio) {
    	GenericRestResponse<AudioFileProperties> g = audioAdapter.save(audio);
    	ResponseEntity<GenericRestResponse<AudioFileProperties>> response = new ResponseEntity<GenericRestResponse<AudioFileProperties>>(g, HttpStatus.OK);
    	return response;
    }

}
