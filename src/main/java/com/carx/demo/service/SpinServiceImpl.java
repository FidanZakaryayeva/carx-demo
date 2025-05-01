package com.carx.demo.service;


import com.carx.demo.dto.CategoryDto;
import com.carx.demo.dto.SpinResultDto;
import com.carx.demo.entity.Category;
import com.carx.demo.entity.Reward;
import com.carx.demo.entity.XpTracker;
import com.carx.demo.enums.RewardType;
import com.carx.demo.repo.CategoryRepository;
import com.carx.demo.repo.RewardRepository;
import com.carx.demo.repo.XpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SpinServiceImpl implements SpinService {
    private final RewardRepository rewardRepository;
    private final CategoryRepository categoryRepository;
    private final XpRepository xpRepository;
    private final Random random = new Random();

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public SpinResultDto spin(Long selectedCategoryId) {

        Optional<Category> categoryOptional = categoryRepository.findById(selectedCategoryId);

        if (!categoryOptional.isPresent()) {
            throw new IllegalArgumentException("Seçilmiş kateqoriya tapılmadı.");
        }
        Category category = categoryOptional.get();
        List<Reward> rewards = rewardRepository.findByCategory(category);

        if (rewards.isEmpty()) {
            throw new IllegalArgumentException("Seçilmiş kateqoriya üçün mükafat tapılmadı.");
        }

        Reward reward = rewards.get(new Random().nextInt(rewards.size()));

        SpinResultDto result = new SpinResultDto();
        result.setDescription(reward.getDescription());
        result.setValue(reward.getValue());
        result.setTryAgain(reward.getType() == RewardType.TRY_AGAIN);

        if (!result.isTryAgain()) {
            XpTracker tracker = xpRepository.findById(1L).orElseThrow();
            tracker.setXp(0);
            xpRepository.save(tracker);
        }

        return result;
    }



    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findCategoryById(id);
        if (Objects.isNull(category)) {
            throw new IllegalArgumentException("Kateqoriya tapilmadi");
        }
        return new CategoryDto(category.getName());

    }


}



























