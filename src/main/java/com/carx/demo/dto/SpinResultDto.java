package com.carx.demo.dto;

import com.carx.demo.enums.RewardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpinResultDto {
    private String description;
   private double value;
   private boolean tryAgain;
}
