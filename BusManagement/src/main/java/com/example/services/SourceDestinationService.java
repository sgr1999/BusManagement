package com.example.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.SourceDestinationModel;
import com.example.dao.SourceDestinationRepository;
import com.example.entites.SourceDestination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceDestinationService {

    @Autowired
    private SourceDestinationRepository sourceDestinationRepository;

    // Add SourceDestination
    public SourceDestination addSource(SourceDestination sourceDestination) {
        try {

            SourceDestination save = sourceDestinationRepository.save(sourceDestination);
            System.out.println(save);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get All SourceDestination
    public List<SourceDestinationModel> getSource() {

        List<SourceDestination> list = null;
        List<SourceDestinationModel> list1 = new ArrayList<>();

        try {

            list = sourceDestinationRepository.findAll();

            list.forEach(e -> {
                list1.add(new SourceDestinationModel(e.getCityId().getCityCode(), e.getCityId().getCityName(),
                        e.getDistrictId().getDistrictCode(), e.getDistrictId().getDistrictName(),
                        e.getStateId().getStateCode(), e.getStateId().getStateName()));
            });

            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get SourceDestination By Id
    public Map<String, Object> getSourceById(Long id) {

        SourceDestination list = null;
        Map<String, Object> map = new HashMap<>();
        try {

            list = sourceDestinationRepository.getById(id);

            map.put("cityCode", list.getCityId().getCityCode());
            map.put("cityName", list.getCityId().getCityName());
            map.put("districtCode", list.getDistrictId().getDistrictCode());
            map.put("districtName", list.getDistrictId().getDistrictName());
            map.put("stateCode", list.getStateId().getStateName());
            map.put("stateName", list.getStateId().getStateName());

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Update SourceDestination By Id
    public SourceDestination updateSourceById(SourceDestination source, Long id) {

        SourceDestination list = null;
        try {
            list = sourceDestinationRepository.getById(id);
            list.setCityId(source.getCityId());
            list.setDistrictId(source.getDistrictId());
            list.setStateId(source.getStateId());

            sourceDestinationRepository.save(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
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
