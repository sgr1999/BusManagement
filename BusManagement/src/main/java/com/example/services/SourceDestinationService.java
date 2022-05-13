package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.SourceDestinationModel;
import com.example.dao.CityRepository;
import com.example.dao.DistrictRepository;
import com.example.dao.SourceDestinationRepository;
import com.example.dao.StateRepository;
import com.example.entites.City;
import com.example.entites.SourceDestination;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceDestinationService {

    @Autowired
    private SourceDestinationRepository sourceDestinationRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StateRepository stateRepository;

    // Add SourceDestination
    public SourceDestination addSource(SourceDestination sourceDestination) {

        City cityId = sourceDestinationRepository.getCityId(sourceDestination.getCityId());

        if (cityId != null) {
            throw new DataAlreadyPresentExceptionHandling("City", "cityId", sourceDestination.getCityId().getCityId());
        }

        stateRepository.findById(sourceDestination.getStateId().getStateId())
                .orElseThrow(() -> new ResourceNotFoundException("State", "id",
                        sourceDestination.getStateId().getStateId()));

        districtRepository.findById(sourceDestination.getDistrictId().getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District", "id",
                        sourceDestination.getDistrictId().getDistrictId()));

        cityRepository.findById(sourceDestination.getCityId().getCityId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("City", "id", sourceDestination.getCityId().getCityId()));

        SourceDestination save = sourceDestinationRepository.save(sourceDestination);
        return save;

    }

    // Get All SourceDestination
    public List<SourceDestinationModel> getSource() {

        List<SourceDestination> list = null;
        List<SourceDestinationModel> list1 = new ArrayList<>();

        list = sourceDestinationRepository.findAll();

        if (list.size() <= 0) {
            throw new ResourceNotFoundException();
        }

        list.forEach(e -> {
            list1.add(new SourceDestinationModel(e.getSourceDestinationId(), e.getCityId().getCityCode(),
                    e.getCityId().getCityName(),
                    e.getDistrictId().getDistrictCode(), e.getDistrictId().getDistrictName(),
                    e.getStateId().getStateCode(), e.getStateId().getStateName()));
        });

        return list1;

    }

    // Get SourceDestination By Id
    public SourceDestinationModel getSourceById(Long id) {

        SourceDestination list = null;
        SourceDestinationModel sd = new SourceDestinationModel();

        list = sourceDestinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SourceDestination", "id", id));

        sd.setCityCode(list.getCityId().getCityCode());
        sd.setCityName(list.getCityId().getCityName());
        sd.setDistrictCode(list.getDistrictId().getDistrictCode());
        sd.setDistrictName(list.getDistrictId().getDistrictName());
        sd.setStateCode(list.getStateId().getStateCode());
        sd.setStateName(list.getStateId().getStateName());
        sd.setId(list.getSourceDestinationId());

        return sd;

    }

    // Update SourceDestination By Id
    public SourceDestination updateSourceById(SourceDestination sourceDestination, Long id) {

        SourceDestination list = null;
      
            list = sourceDestinationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SourceDestination", "id", id));

           // City cityId = sourceDestinationRepository.findById(sourceDestination.getCityId().getCityId());

        if (list.getCityId().getCityId() != sourceDestination.getCityId().getCityId()) {
           // throw new DataNotMatchException("Source Destination", "id", id,"cityId");
        }

        stateRepository.findById(sourceDestination.getStateId().getStateId())
                .orElseThrow(() -> new ResourceNotFoundException("State", "id",
                        sourceDestination.getStateId().getStateId()));

        districtRepository.findById(sourceDestination.getDistrictId().getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District", "id",
                        sourceDestination.getDistrictId().getDistrictId()));

        cityRepository.findById(sourceDestination.getCityId().getCityId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("City", "id", sourceDestination.getCityId().getCityId()));



            list.setCityId(sourceDestination.getCityId());
            list.setDistrictId(sourceDestination.getDistrictId());
            list.setStateId(sourceDestination.getStateId());

            sourceDestinationRepository.save(list);
            return list;
       
    }

    // Delete SourceDestination By Id
    public SourceDestination deleteSourceById(Long id) {

        SourceDestination byId = null;
        try {
            byId = sourceDestinationRepository.getById(id);
            sourceDestinationRepository.deleteById(id);
            return byId;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return null;
    }
}
