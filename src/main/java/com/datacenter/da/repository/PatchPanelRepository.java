package com.datacenter.da.repository;

import com.datacenter.da.entity.PatchPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatchPanelRepository extends JpaRepository<PatchPanel, Long> {
}
