package com.example.javacourse.wallet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class WalletService {

    private List<Wallet> walletList = new ArrayList<>(List.of(
            new Wallet(1, "Saving house"),
            new Wallet(2, "Saving car"),
            new Wallet(3, "Penny Service")
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
