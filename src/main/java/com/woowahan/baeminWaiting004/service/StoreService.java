package com.woowahan.baeminWaiting004.service;

import java.util.List;

import com.woowahan.baeminWaiting004.model.Store;

public interface StoreService {

	List<Store> getAllStores();

	void addStore(String storeName, String storeTel, String storeAddress, String storeDescription, String storeLatitude,
			String storeLongitude, int storeIsOpened);
}
