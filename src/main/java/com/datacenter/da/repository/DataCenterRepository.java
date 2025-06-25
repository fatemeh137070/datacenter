package com.datacenter.da.repository;

import com.datacenter.da.entity.DataCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataCenterRepository extends JpaRepository<DataCenter, Long> {}
