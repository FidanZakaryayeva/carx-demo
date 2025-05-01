package com.carx.demo.service;

import com.carx.demo.dto.RewardDto;

public interface XpService {

   int transaction(Long userId);
   RewardDto claimReward(Long userId, int xpLevel);
   int getCurrentXp(Long userId);

}
