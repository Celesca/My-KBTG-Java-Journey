package com.usermanagement.usermanagement.wallet;

// Record เป็น Invitable เปลี่ยนแปลงอะไรไม่ได้

import com.usermanagement.usermanagement.profile.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 20, message = "Wallet name must be between 3 and 20 characters")
    private String walletName;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "profile_email", referencedColumnName = "email")
    private Profile profile;

    public Wallet() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}