package com.carx.demo.controller;

import com.carx.demo.dto.RewardDto;
import com.carx.demo.entity.Reward;
import com.carx.demo.service.XpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/xp")
public class XpController {
    private final XpService xpService;
    private  final Long userId=1L;

    @GetMapping("/current-xp")
    public int currentXp() {
        return xpService.getCurrentXp(userId);
    }

    @PostMapping("/claim-reward")
    public RewardDto reward(@RequestParam int xpLevel) {
        return xpService.claimReward(userId,xpLevel);
    }

    @PostMapping("/transaction")
    public int transaction(@RequestParam Long userId) {
        return xpService.transaction(userId);
    }
}
