package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.Model.CityModel;
import com.example.dao.CityRepository;
import com.example.dao.DistrictRepository;
import com.example.entites.City;
import com.example.entites.District;
import com.example.exception.DataAlreadyPresentExceptionHandling;
import com.example.exception.DataIntegrityViolationExceptionHandling;
import com.example.exception.DataNotMatchException;
import com.example.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    DistrictRepository districtRepository;

    // Add City
    public City addCity(City city) {

        Long code = cityRepository.getCityCode(city.getCityCode());
        String name = cityRepository.getCityName(city.getCityName());

        districtRepository.findById(city.getDistrictId().getDistrictId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("District", "id", city.getDistrictId().getDistrictId()));

        if (code != null && name != null) {
            throw new DataAlreadyPresentExceptionHandling("City", "cityCode, cityName");
        }

        if (code != null) {
            throw new DataAlreadyPresentExceptionHandling("City", "cityCode", code);
        }

        if (name != null) {
            throw new DataAlreadyPresentExceptionHandling("City", "cityName");
        }

        cityRepository.save(city);

        return city;

    }

    // Get All City
    public List<CityModel> getCity() {

        List<City> list = cityRepository.findAll();
        List<CityModel> list1 = new ArrayList<>();

        list.forEach(e -> {
            list1.add(new CityModel(e.getCityId(), e.getCityCode(), e.getCityName()));
        });

        return list1;

    }

    // Get City By Id
    public CityModel getCityById(Long id) {

        City list = null;

        list = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        CityModel c = new CityModel(list.getCityId(), list.getCityCode(), list.getCityName());
        return c;

    }

    // Update City By Id
    public City updateCityById(City city, Long id) {

        City list = null;

        list = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        districtRepository.findById(city.getDistrictId().getDistrictId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("District", "id", city.getDistrictId().getDistrictId()));

        list.setCityCode(city.getCityCode());
        list.setCityName(city.getCityName());
        list.setDistrictId(city.getDistrictId());

        try {
            cityRepository.save(list);
            return list;
        } catch (Exception e) {
            throw new DataNotMatchException(id);
        }

    }

    // Delete By Id
    public void deleteCityById(Long id) {

        City byId = null;

        byId = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", id));

        try {

            cityRepository.delete(byId);
        } catch (Exception e) {
            throw new DataIntegrityViolationExceptionHandling("City", id);
        }
    }
}
