package com.usermanagement.usermanagement.wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WalletUpdateDto (
        @NotNull
        @Size(min = 3, max = 20, message = "Wallet name must be between 3 and 20 characters")
        String walletName
){

}
