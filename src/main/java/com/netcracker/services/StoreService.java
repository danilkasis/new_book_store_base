package com.netcracker.services;


import com.netcracker.entities.Store;
import com.netcracker.infrastructure.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class StoreService {


    private StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void insert(Store store) {
        storeRepository.insert(store);
    }

    public List<Store> loadAll() {
        return storeRepository.loadAll();
    }

    public Store loadByStoreName(String storeName) {
        return storeRepository.loadByStoreName(storeName);
    }

    public Store loadById(String id) {
        return storeRepository.loadById(id);
    }

    public List<Store> loadByStreetName(String streetName){
        return storeRepository.loadByStreetName(streetName);
    }

    public void deleteByStoreName(String storeName){
        storeRepository.deleteByStoreName(storeName);
    }

    public void deleteById(String id){
       storeRepository.loadById(id);
    }

    public void deleteAll(){
        storeRepository.deleteAll();
    }

    public void deleteByStreetName(String streetName){
        storeRepository.loadByStreetName(streetName);
    }
}
