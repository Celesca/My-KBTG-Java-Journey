package com.usermanagement.usermanagement.wallet;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/wallets")
public class WalletController {

    private WalletService walletService;

    public WalletController() {
        this.walletService = new WalletService();
    }

    @GetMapping("")
    public List<Wallet> getWalletList() {
        return walletService.getWalletList();
    }

    @PostMapping("")
    public Wallet createWallet(@RequestBody WalletRequest request){
        return walletService.createWallet(request);
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id){
        return walletService.getWalletById(id);
    }


}


