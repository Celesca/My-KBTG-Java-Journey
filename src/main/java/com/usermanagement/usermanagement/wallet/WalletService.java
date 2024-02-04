package com.usermanagement.usermanagement.wallet;

import com.usermanagement.usermanagement.exception.DuplicationException;
import com.usermanagement.usermanagement.exception.InternalServiceException;
import com.usermanagement.usermanagement.exception.NotFoundException;
import com.usermanagement.usermanagement.mail.GoogleMailService;
import com.usermanagement.usermanagement.mail.MailService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    // Injection
    private final MailService mailService;
    private final WalletRepository walletRepository;

    public WalletService(@Qualifier("googleMail") MailService mailService, WalletRepository walletRepository) {
        this.mailService = mailService;
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWalletList() {
        List<Wallet> walletList = walletRepository.findAll();
        return walletList;
    }

    public Wallet createWallet(WalletRequestDto request) {
        Wallet wallet = new Wallet();
        wallet.setWalletName(request.walletName());
        wallet.setActive(true);
        walletRepository.save(wallet);
        return wallet;
    }

    public Wallet getWalletById(Integer id) {
//        return walletList.stream().filter(wallet -> wallet.getId().equals(id)).findFirst()
//                .orElseThrow(() -> new NotFoundException("Wallet not found by Id"));
        return null;
    }

    public Wallet updateWallet(@RequestBody UpdateWalletRequest request, Integer id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id));
        if (optionalWallet.isEmpty()) {
            throw new BadRequestException("Invalid wallet id");
        }

        String wallet = optionalWallet.get();
        wallet.setWalletName(request.walletname());

        return null;
    }

    public void deleteWallet(Integer id) {
//        getWalletById(id);
//
//        walletList.removeIf(wallet -> wallet.getId().equals(id));

    }
}
