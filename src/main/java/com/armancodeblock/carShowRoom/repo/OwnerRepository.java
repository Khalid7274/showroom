package com.armancodeblock.carShowRoom.repo;

import com.armancodeblock.carShowRoom.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
