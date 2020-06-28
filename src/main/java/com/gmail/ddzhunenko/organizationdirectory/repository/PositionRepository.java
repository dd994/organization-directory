package com.gmail.ddzhunenko.organizationdirectory.repository;

import com.gmail.ddzhunenko.organizationdirectory.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {


}
