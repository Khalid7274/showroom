package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwner();
    Owner create(Owner owner);
    Owner deleteOwner(Long id);

    Owner findOwnerById(Long ownerid);
}
