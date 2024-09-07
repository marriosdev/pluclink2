package com.pluclink.api.modules.Link.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluclink.api.modules.Link.models.LinkTracker;

public interface LinkTrackerRepository extends JpaRepository<LinkTracker, UUID> {

}
