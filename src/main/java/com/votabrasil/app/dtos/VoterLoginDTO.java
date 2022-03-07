package com.votabrasil.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Interface responsible for the validation of the credentials of the user.
 * 
 * @author Boaz
 * @since 07/03/2022
 * @version 1.0
 */
public class VoterLoginDTO {

    private @NotBlank @Email String email;
    private @NotBlank String password;

    public VoterLoginDTO() {
    }

    public VoterLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
