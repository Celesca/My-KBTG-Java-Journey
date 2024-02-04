package com.usermanagement.usermanagement.wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/wallets")
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("")
    public List<Wallet> getWalletList() {
        return walletService.getWalletList();
    }

    @PostMapping("")
    public Wallet createWallet(@RequestBody WalletRequestDto request){
        return walletService.createWallet(request);
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id){
        return walletService.getWalletById(id);
    }

    @PutMapping("/{id}")
    public Wallet updateWallet(@Validated @RequestBody UpdateWalletRequest request, @PathVariable Integer id) {
        return walletService.updateWallet(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteWallet(@PathVariable Integer id) {
        walletService.deleteWallet(id);
        return "ok";
    }
}

record UpdateWalletRequest(
    @NotNull
    @Size(min = 3, max = 20, message = "Wallet name must be between 3 and 20 characters")
    String walletName)
{ }