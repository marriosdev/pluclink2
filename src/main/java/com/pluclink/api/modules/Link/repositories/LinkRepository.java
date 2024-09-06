package com.pluclink.api.modules.Link.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.pluclink.api.modules.Link.models.Link;

public interface LinkRepository extends JpaRepository<Link, UUID> {

}
