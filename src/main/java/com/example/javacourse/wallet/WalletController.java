package com.example.javacourse.wallet;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("")
    public List<Wallet> getWalletList() {
        return walletService.getWalletList();
    }

    @PostMapping("")
    public Wallet createWallet(@RequestBody WalletRequest request) throws Exception {
        if (request.walletName() == null || request.walletName().trim().isEmpty()) {
            throw new Exception("Wallet name is required");
        }


        return walletService.createWallet(request);
    }
}


