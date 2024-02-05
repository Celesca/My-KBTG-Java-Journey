package com.usermanagement.usermanagement.wallet;

import com.usermanagement.usermanagement.exception.BadRequestException;
import com.usermanagement.usermanagement.exception.DuplicationException;
import com.usermanagement.usermanagement.exception.InternalServiceException;
import com.usermanagement.usermanagement.exception.NotFoundException;
import com.usermanagement.usermanagement.mail.GoogleMailService;
import com.usermanagement.usermanagement.mail.MailService;
import com.usermanagement.usermanagement.profile.Profile;
import com.usermanagement.usermanagement.profile.ProfileRepository;
import jakarta.transaction.Transactional;
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
    private final ProfileRepository profileRepository;

    public WalletService(@Qualifier("googleMail") MailService mailService, WalletRepository walletRepository
    , ProfileRepository profileRepository) {
        this.mailService = mailService;
        this.walletRepository = walletRepository;
        this.profileRepository = profileRepository;
    }

    public List<Wallet> getWalletList() {
        List<Wallet> walletList = walletRepository.findAll();
        return walletList;
    }

    @Transactional
    public Wallet createWallet(WalletRequestDto requestDto) {
        Optional<Profile> optionalProfile = profileRepository.findByEmail(requestDto.getEmail());
        Profile profile;
        // if there are optionalProfile just get it
        if (optionalProfile.isPresent()) {
            profile = optionalProfile.get();
        }
        // if no profile just create the new one.
        else {
            profile = new Profile();
            profile.setName("Someone");
            profile.setEmail(requestDto.getEmail());
            profileRepository.save(profile);
        }
        Wallet wallet = new Wallet();
        wallet.setWalletName(requestDto.getName());
        wallet.setActive(true);
        wallet.setProfile(profile);
        walletRepository.save(wallet);
        return wallet;
    }

    public Wallet getWalletById(Integer id) {
//        return walletList.stream().filter(wallet -> wallet.getId().equals(id)).findFirst()
//                .orElseThrow(() -> new NotFoundException("Wallet not found by Id"));
        return null;
    }

    public Wallet updateWallet(@RequestBody WalletUpdateDto requestDto, Integer id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id));
        if (optionalWallet.isEmpty()){
            throw new BadRequestException("Invalid wallet id");
        }

        Wallet wallet = optionalWallet.get();
        wallet.setWalletName(requestDto.walletName());
        walletRepository.save(wallet);
        return wallet;
    }

    public void deleteWallet(Integer id) {
        walletRepository.deleteById(Long.valueOf(id));
    }

    public void activeAllWallet(){
        walletRepository.setAllWalletActive();
    }
}
