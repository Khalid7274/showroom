package com.armancodeblock.carShowRoom.service;

import com.armancodeblock.carShowRoom.entity.Owner;
import com.armancodeblock.carShowRoom.repo.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerImpl implements OwnerService{
    private final OwnerRepository ownerRepository;
    @Autowired
    public OwnerImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner deleteOwner(Long id) {
        Optional<Owner> optionalOwner=ownerRepository.findById(id);
        if(optionalOwner.isPresent()){
            Owner existOwner= optionalOwner.get();
            ownerRepository.deleteById(id);
            return existOwner;
        }else {
            throw new EntityNotFoundException("Owner not found with id: "+id);
        }
    }

    @Override
    public Owner findOwnerById(Long ownerid) {
        return null;
    }
}
