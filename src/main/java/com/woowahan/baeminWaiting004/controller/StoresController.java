package com.woowahan.baeminWaiting004.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowahan.baeminWaiting004.model.Store;
import com.woowahan.baeminWaiting004.model.StoreJsonType;
import com.woowahan.baeminWaiting004.service.StoreService;

@Controller
public class StoresController {
	
	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/stores", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getStores() throws JsonProcessingException{
		
		List<Store> stores = storeService.getAllStores();
		List<StoreJsonType> storeJsonTypeList = new ArrayList<StoreJsonType>();
		
		for (int i = 0; i < stores.size(); i++) {
			StoreJsonType storeJsonType = new StoreJsonType();
			Store store = stores.get(i);
			storeJsonType.setStoreIsOpened(store.getOpened());
			storeJsonType.setStoreLatitude(store.getLatitude());
			storeJsonType.setStoreLongitude(store.getLongitude());
			storeJsonType.setStoreName(store.getTitle());
			storeJsonTypeList.add(storeJsonType);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(storeJsonTypeList);
	}
}
