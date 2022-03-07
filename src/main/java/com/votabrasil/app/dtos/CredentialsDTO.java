package com.votabrasil.app.dtos;

/**
 * Interface responsible for the credentials of the user.
 * 
 * @author Boaz
 * @since 07/03/2022
 * @version 1.0
 */
public class CredentialsDTO {

    private Long id;
    private String name;
    private String email;
    private String basicToken;

    public CredentialsDTO() {
    }

    public CredentialsDTO(Long id, String name, String email, String basicToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.basicToken = basicToken;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBasicToken() {
        return this.basicToken;
    }

    public void setBasicToken(String basicToken) {
        this.basicToken = basicToken;
    }

}
