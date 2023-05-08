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
        public ResponseEntity<Transfer> addTransfer(@ModelAttribute Transfer transfer) {
            Transfer savedTransfer = transferService.addTransfer(transfer);
            return ResponseEntity.ok(savedTransfer);
        }

        @GetMapping("/list")
        public ResponseEntity<List<Transfer>> getAllTransfers() {
            List<Transfer> transfers = transferService.getAllTransfers();
            return ResponseEntity.ok(transfers);
        }
    }
