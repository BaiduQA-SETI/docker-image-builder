package com.baidu.ubqa.entity;

import com.spotify.docker.client.messages.AuthConfig;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Created by zhaoming03 on 2017/12/4.
 */
@Data
public class Registry {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    @NotBlank
    private String serverAddress;

    public AuthConfig toAuthConfig() {
        return AuthConfig
                .builder()
                .serverAddress(this.serverAddress)
                .username(this.username)
                .password(this.password)
                .email(this.email).build();
    }
}
