package com.usermanagement.usermanagement.wallet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WalletRequestDto{

        @NotNull
        @Size(min = 3, max = 20, message = "Wallet name must be between 3 and 20 characters")
        private String name;

        @NotNull
        @Email(message = "Email should be valid")
        private String email;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}