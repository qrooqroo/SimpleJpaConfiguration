package com.woowahan.baeminWaiting004;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowahan.baeminWaiting004.model.Store;
import com.woowahan.baeminWaiting004.service.StoreService;

@Controller
public class StoreListController {
	
	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/store/list", method = RequestMethod.GET)
	@ResponseBody
	public String storeListAll() throws JsonProcessingException{
		
		List<Store> stores = storeService.getAllStores();
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.writeValueAsString(stores);
	}
}
