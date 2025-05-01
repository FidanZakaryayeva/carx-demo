package com.carx.demo.repo;

import com.carx.demo.entity.XpTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XpRepository extends JpaRepository<XpTracker,Long> {
}
