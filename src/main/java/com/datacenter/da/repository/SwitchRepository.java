package com.datacenter.da.repository;

import com.datacenter.da.entity.Switch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitchRepository extends JpaRepository<Switch, Long> {
}
