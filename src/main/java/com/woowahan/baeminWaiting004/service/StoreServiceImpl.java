package com.woowahan.baeminWaiting004.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woowahan.baeminWaiting004.model.Store;
import com.woowahan.baeminWaiting004.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Store> getAllStores() {
		
		List<Store> stores = storeRepository.findAll();
		
		return stores;
	}
}
