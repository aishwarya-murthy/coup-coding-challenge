package com.example.coup.controller;

import com.example.coup.request.RequiredFleetEngineersRequest;
import com.example.coup.service.MaintenanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class MaintenanceControllerTest {

    @InjectMocks
    private MaintenanceController maintenanceController;

    @Spy
    private MaintenanceService maintenanceService;

    @Test
    public void shouldReturnMinimumNumberOfRequiredFleetEngineers() {
        RequiredFleetEngineersRequest request =
                RequiredFleetEngineersRequest.builder()
                        .scooters(new int[]{15, 10})
                        .C(12)
                        .P(5)
                        .build();

        assertThat(maintenanceController.findNumberOfFleetEngineers(request), is("{ fleet_engineers: 3}"));
    }

}