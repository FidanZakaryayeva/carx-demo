package com.carx.demo.service;

import com.carx.demo.dto.RewardDto;
import com.carx.demo.entity.XpTracker;
import com.carx.demo.enums.RewardType;
import com.carx.demo.repo.XpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XpServiceImpl implements XpService {
    private final SpinService spinService;
    private final XpRepository xpRepository;


    @Override
    public int transaction(Long userId) {
        XpTracker tracker = xpRepository.findById(userId)
                .orElse(new XpTracker(userId, 0));
        tracker.setXp(tracker.getXp() + 10);
        xpRepository.save(tracker);
        return tracker.getXp();
    }

    @Override
    public RewardDto claimReward(Long userId, int xpLevel) {
        if (!List.of(100, 200, 300, 400,500).contains(xpLevel)) {
            throw new IllegalArgumentException("Düzgün XP səviyyəsi deyil.");
        }

        XpTracker tracker = xpRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("XP məlumatı tapılmadı."));

        if (tracker.getXp() < xpLevel) {
            throw new IllegalArgumentException("Kifayət qədər XP yoxdur.");
        }

        tracker.setXp(tracker.getXp() - xpLevel);
        xpRepository.save(tracker);
        if (xpLevel == 500) {
         return new RewardDto("Çarx seçimi aktivləşdi! İndi çarxı fırlada bilərsiniz.", null);
        }
        return new RewardDto("Sabit endirim - " + xpLevel + " XP səviyyəsi", RewardType.DISCOUNT);
    }


    @Override
    public int getCurrentXp(Long userId) {
        return xpRepository.findById(userId)
                .orElse(new XpTracker(userId, 0))
                .getXp();
    }
}