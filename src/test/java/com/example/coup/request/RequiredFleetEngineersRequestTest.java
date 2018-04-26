package com.example.coup.request;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequiredFleetEngineersRequestTest {

    @Test
    public void shouldHaveAConstraintViolationWhenPOrCIsNotProvided() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequiredFleetEngineersRequest>> constraintViolations = validator.validate(RequiredFleetEngineersRequest.builder()
                .scooters(new int[]{15, 10})
                .build());

        assertThat(constraintViolations.size(), is(2));
    }

    @Test
    public void shouldHaveAConstraintViolationWhenPIsLessThan1() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequiredFleetEngineersRequest>> constraintViolations = validator.validate(RequiredFleetEngineersRequest.builder()
                .scooters(new int[]{15, 10})
                .P(0)
                .C(12)
                .build());

        assertThat(constraintViolations.size(), is(1));
    }

    @Test
    public void shouldHaveAConstraintViolationWhenCIsGreaterThan1000() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequiredFleetEngineersRequest>> constraintViolations = validator.validate(RequiredFleetEngineersRequest.builder()
                .scooters(new int[]{15, 10})
                .P(10)
                .C(1000)
                .build());

        assertThat(constraintViolations.size(), is(1));
    }

}