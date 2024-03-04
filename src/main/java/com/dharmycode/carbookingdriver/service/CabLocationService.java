package com.dharmycode.carbookingdriver.service;

import com.dharmycode.carbookingdriver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public CabLocationService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }

}
