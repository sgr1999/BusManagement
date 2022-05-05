package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.Model.CityModel;
import com.example.dao.CityRepository;
import com.example.dao.DistrictRepository;
import com.example.entites.City;
import com.example.entites.District;

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
        City save = null;
        District dd = null;
        try {

            Long c = city.getDistrictId().getDistrictId();
            dd = districtRepository.getById(c);

            if (dd != null) {
                city.setDistrictId(dd);
                save = cityRepository.save(city);
                return save;
            } else {
                throw new Exception("district id does not exist in database");
            }



        } catch (DataIntegrityViolationException e1) {
            System.out.println("--city code or city name already does exist in database");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }

    }

    // Get All City
    public List<CityModel> getCity() {

        List<CityModel> list = new ArrayList<>();
        try {

            list = cityRepository.findData();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Get City By Id
    public CityModel getCityById(Long id) {

        CityModel list = null;
        try {

            list = cityRepository.getDataById(id);
            System.out.println("------------------"+list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            
        }
        return null;
    }

    // Update City By Id
    public City updateCityById(City city, Long id) {

        City list = null;
        try {
            list = cityRepository.getById(id);
            list.setCityCode(city.getCityCode());
            list.setCityName(city.getCityName());
            list.setDistrictId(city.getDistrictId());
            

            cityRepository.save(list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    // Delete By Id
    public City deleteCityById(Long id) {

        City byId = null;
        try {
            byId = cityRepository.getById(id);
            cityRepository.deleteById(id);

            return byId;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return null;
    }
}
