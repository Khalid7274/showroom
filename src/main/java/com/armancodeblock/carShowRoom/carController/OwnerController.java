package com.armancodeblock.carShowRoom.carController;

import com.armancodeblock.carShowRoom.entity.Owner;
import com.armancodeblock.carShowRoom.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/owner")
public class OwnerController {
    private final OwnerService ownerService;
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Owner>> getAllCarsOwner(){
        List<Owner> owners= ownerService.getAllOwner();
        return new ResponseEntity<>(owners,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Owner> addNewOwner(@RequestBody Owner owner){
        Owner createOwner= ownerService.create(owner);
        return new ResponseEntity<>(createOwner,HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Owner> removeOwner(@PathVariable Long id){
        Owner reOwner=ownerService.deleteOwner(id);
        return new ResponseEntity<>(reOwner,HttpStatus.OK);
    }
}
