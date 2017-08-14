package com.woowahan.baeminWaiting004.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.woowahan.baeminWaiting004.model.SampleJsonObject;
import com.woowahan.baeminWaiting004.service.StoreService;

@Controller
public class SampleDataInputPageController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value="/sample/json", method=RequestMethod.GET)
	public String getSampleJsonPage(){
		return "sampleJson";
	}

	@RequestMapping(value="/sample/json", method=RequestMethod.POST)
	public String getSampleJson(@RequestParam String sampleJson) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		List<SampleJsonObject> sampleJsonObjectList = objectMapper.readValue(sampleJson, TypeFactory.defaultInstance().constructCollectionType(List.class, SampleJsonObject.class));
		for (int i = 0; i < sampleJsonObjectList.size(); i++) {
			SampleJsonObject sampleJsonObject = sampleJsonObjectList.get(i);
			storeService.addStore(sampleJsonObject.getStoreName(), sampleJsonObject.getStoreTel(), sampleJsonObject.getStoreAddress(), 
					sampleJsonObject.getStoreDescription(), sampleJsonObject.getStoreLatitude(), sampleJsonObject.getStoreLongitude(), sampleJsonObject.getStoreIsOpened());
			
		}
		
		return sampleJson;
	}
}
