package com.paymybuddy.Controllers;

import com.paymybuddy.Models.Transfer;
import com.paymybuddy.Services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;



    @PostMapping("/add")
    public ResponseEntity<Transfer> addTransfer(@RequestParam Long senderAccountId,
                                                @RequestParam Long receiverAccountId,
                                                @RequestParam String description,
                                                @RequestParam float amount) {
        try {
            Transfer savedTransfer = transferService.addTransfer(senderAccountId, receiverAccountId, description, amount);
            return ResponseEntity.ok(savedTransfer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add transfer", e);
        }
    }


    @GetMapping("/list")
        public ResponseEntity<List<Transfer>> getAllTransfers() {
            List<Transfer> transfers = transferService.getAllTransfers();
            return ResponseEntity.ok(transfers);
        }
    }
