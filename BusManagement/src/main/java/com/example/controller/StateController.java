package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.example.entites.State;
import com.example.response.ApiResponse1;
import com.example.services.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    // Add State
    @PostMapping("/addState")
    public ResponseEntity<ApiResponse1> addState(@Valid @RequestBody State state) {

        stateService.addState(state);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("state data added successfully!!"),
                HttpStatus.CREATED);

    }

    // Get State Details
    @GetMapping("/getState")
    public ResponseEntity<List<State>> getState() {

        List<State> list = stateService.getState();

        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    // Get State By Id
    @GetMapping("/getState/{id}")
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id) {

        State add = stateService.getStateById(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(add);

    }

    // Update State By Id
    @PutMapping("/updateState/{id}")
    public ResponseEntity<ApiResponse1> updateStateById(@RequestBody State state, @PathVariable("id") Long id) {

        stateService.updateStateById(state, id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("state data updated successfully!!"), HttpStatus.OK);

    }

    // Delete State By Id
    @DeleteMapping("/deleteState/{id}")
    public ResponseEntity<ApiResponse1> deleteStateById(@PathVariable("id") Long id) {

        stateService.deleteStateById(id);

        return new ResponseEntity<ApiResponse1>(new ApiResponse1("state data deleted successfully!!"), HttpStatus.OK);
    }
}
