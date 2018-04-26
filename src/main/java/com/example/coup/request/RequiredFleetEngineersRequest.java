package com.example.coup.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class RequiredFleetEngineersRequest {

    @NotNull
    @Size(min=1, max=100)
    @ApiModelProperty(value = "Array containing number of scooters in each district", required = true)
    private int[] scooters;

    @NotNull
    @Min(1)
    @Max(999)
    @ApiModelProperty(value = "Number of scooters that can be maintained by the Fleet Manager", required = true)
    private int C;

    @NotNull
    @Min(1)
    @Max(1000)
    @ApiModelProperty(value = "Number of scooters that can be maintained by a Fleet Engineer", required = true)
    private int P;

}
