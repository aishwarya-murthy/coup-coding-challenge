package com.example.coup.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class MaintenanceServiceTest {

    @InjectMocks
    private MaintenanceService maintenanceService;

    @Test
    public void shouldReturnMinimumNumberOfFleetEngineersWhenMoreThanOneDistrictHasMoreThanManagerCapcity() {
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{15, 12}, 12, 5), is(3));
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{14, 15, 8}, 12, 5), is(6));
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{14, 15, 12}, 12, 5), is(6));
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{11, 13, 7}, 10, 3), is(8));
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{3, 12, 7}, 2, 10), is(3));
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{67, 102, 7}, 100, 3), is(27));
    }

    @Test
    public void shouldReturnMinimumNumberOfFleetEngineersWhenEachDistrictHasLessThanManagerCapacity() {
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{9, 9}, 12, 5), is(2));
    }

    @Test
    public void shouldReturnMinimumNumberOfFleetEngineersWhenAnyDistrictHasZeroScooters() {
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{9, 9, 0, 12}, 12, 5), is(4));
    }

    @Test
    public void shouldReturnMinimumNumberOfFleetEngineersWhenEachDistrictHasZeroScooters() {
        assertThat(maintenanceService.findMinimumRequiredFleetEngineers(new int[]{0, 0, 0, 0}, 12, 5), is(0));
    }

}