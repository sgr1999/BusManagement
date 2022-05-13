package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.example.Model.DistrictModel;
import com.example.dao.DistrictRepository;
import com.example.dao.StateRepository;
import com.example.entites.District;
import com.example.entites.State;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataIntegrityViolationExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StateRepository stateRepository;

    // Add District

    public District addDistrict(District district) {
        District save = null;

        Long code = districtRepository.getDistrictCode(district.getDistrictCode());
        String name = districtRepository.getDistrictName(district.getDistrictName());

        stateRepository.findById(district.getStateId().getStateId())
                .orElseThrow(() -> new ResourceNotFoundException("State", "id", district.getStateId().getStateId()));

        if (code != null && name != null) {
            throw new DataAlreadyPresentExceptionHandling("District", "districtCode , districtName");
        }

        if (code != null) {
            throw new DataAlreadyPresentExceptionHandling("District", "districtCode", code);
        }

        if (name != null) {
            throw new DataAlreadyPresentExceptionHandling("District", "districtName");
        }

        districtRepository.save(district);
        return save;

    }

    // Get All District
    public List<DistrictModel> getDistrict() {

        List<District> data = null;
        List<DistrictModel> list = new ArrayList<>();
        data = districtRepository.findAll();

        if (data.size() <= 0) {
            throw new ResourceNotFoundException();
        }

        data.forEach(e -> {
            list.add(new DistrictModel(e.getDistrictId(), e.getDistrictCode(), e.getDistrictName()));
        });

        return list;
    }

    // Get District By Id
    public DistrictModel getDistrictById(Long id) {

        District list = null;

        list = districtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("District", "id", id));

        DistrictModel d = new DistrictModel(list.getDistrictId(), list.getDistrictCode(), list.getDistrictName());

        return d;
    }

    // Update District By Id
    public District updateDistrictById(District district, Long id) {

        District list = null;

        list = districtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("District", "id", id));

        list.setDistrictCode(district.getDistrictCode());
        list.setDistrictName(district.getDistrictName());

        try {

            list = districtRepository.save(list);
            return list;
        } catch (Exception e) {
            throw new DataNotMatchException(id);
        }

    }

    // Delete By Id
    public void deleteDistrictById(Long id) {

        districtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        try {

            districtRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataIntegrityViolationExceptionHandling("State", id);
        }
    }
}
