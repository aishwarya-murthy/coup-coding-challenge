package com.example.coup.service;

import org.springframework.stereotype.Component;

@Component
public class MaintenanceService {

    public int findMinimumRequiredFleetEngineers(int[] scooters, int numberOfScootersPerManager, int noOfScootersPerEngineer) {

        int managerDistrict = getBestManagerDistrict(scooters, numberOfScootersPerManager, noOfScootersPerEngineer);

        int noOfRequiredFleetEngineers = 0;
        for (int i = 0; i < scooters.length; i++) {

            int scootersInDistrict = scooters[i];

            if (i == managerDistrict) {
                scootersInDistrict -= numberOfScootersPerManager;
            }

            noOfRequiredFleetEngineers += noOfEngineersRequiredPerDistrict(scootersInDistrict, noOfScootersPerEngineer);
        }
        return noOfRequiredFleetEngineers;
    }

    private int getBestManagerDistrict(int[] scooters, int noOfScootersManagerCanService, int noOfScootersPerEngineer) {
        int managerDistrictIndex = 0;
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < scooters.length; i++) {
            int scootersInDistrict = scooters[i];

            int scootersAfterManagerHasServiced = scootersInDistrict - noOfScootersManagerCanService;

            if (scootersAfterManagerHasServiced >= 0 && scootersAfterManagerHasServiced % noOfScootersPerEngineer == 0) {
                return i;
            }

            if (scootersAfterManagerHasServiced > 0 && scootersAfterManagerHasServiced < smallestDifference) {
                smallestDifference = scootersAfterManagerHasServiced;
                managerDistrictIndex = i;
            }
        }
        return managerDistrictIndex;
    }

    private int noOfEngineersRequiredPerDistrict(int scootersInDistrict, int noOfScootersEngineerCanService) {
        if (scootersInDistrict <= 0) {
            return 0;
        }
        if (scootersInDistrict < noOfScootersEngineerCanService) {
            return 1;
        }
        int noOfEngineersRequired = scootersInDistrict / noOfScootersEngineerCanService;
        return scootersInDistrict % noOfScootersEngineerCanService == 0 ? noOfEngineersRequired : noOfEngineersRequired + 1;
    }

}
