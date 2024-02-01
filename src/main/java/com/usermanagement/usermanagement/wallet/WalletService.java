package com.usermanagement.usermanagement.wallet;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private List<Wallet> walletList = new ArrayList<>(List.of(
            new Wallet(1, "Saving house"),
            new Wallet(2, "Your Wallet"),
            new Wallet(3, "Their Wallet")
    ));

    public List<Wallet> getWalletList() {
        return walletList;
    }

    public Wallet createWallet(WalletRequest request) {
        Optional<Integer> maxId = walletList.stream()
                .map(Wallet::id)
                .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        Wallet wallet = new Wallet(nextId, request.walletName());
        walletList.add(wallet);
        return wallet;
    }

}
