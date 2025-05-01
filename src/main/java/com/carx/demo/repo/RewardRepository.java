package com.carx.demo.repo;

import com.carx.demo.dto.SpinResultDto;
import com.carx.demo.entity.Category;
import com.carx.demo.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    List<Reward> findByCategory(Category category);

}
