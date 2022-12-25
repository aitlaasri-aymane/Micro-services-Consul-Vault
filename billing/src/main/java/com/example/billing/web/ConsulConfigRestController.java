package com.example.billing.web;

import com.example.billing.config.ConsulConfig;
import com.example.billing.config.VaultConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
@AllArgsConstructor
public class ConsulConfigRestController {
    private ConsulConfig consulConfig;
    private VaultConfig vaultConfig;

   /* @Value("${token.refreshTokenTimeout}")
    private Long refreshTokenTimeout;
    @Value("${token.accessTokenTimeout}")
    private Long accessTokenTimeout;*/

    @GetMapping("/conculparams")
    /*public Map<String,Long> getRefreshTokenTimeout(){
        return Map.of("refreshTokenTimeout",refreshTokenTimeout,"accessTokenTimeout",accessTokenTimeout);
    }*/
    public ConsulConfig getConsulParams(){
        return consulConfig;
    }
    @GetMapping("/vaultparams")
    public VaultConfig getVaultParams(){
        return vaultConfig;
    }

    @GetMapping("/myconfig")
    public Map<String,Object> getMyConfig(){
        return Map.of("ConsulConfig",consulConfig,"vaultConfig",vaultConfig);
    }
}
