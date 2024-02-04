package com.usermanagement.usermanagement.wallet;

// Record เป็น Invitable เปลี่ยนแปลงอะไรไม่ได้

public class Wallet {
    private Integer id;
    private String walletName;
    private String email;

    public Wallet(Integer id, String walletName, String email) {
        this.id = id;
        this.walletName = walletName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getWalletName() {
        return walletName;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
