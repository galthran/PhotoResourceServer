package com.jarosinski.ws.api.photoresourceserver.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmRoles = (Map<String, Object>) jwt.getClaims().get("realm_access");

        if (realmRoles == null || realmRoles.isEmpty()) {
            return List.of();
        }

        Collection<GrantedAuthority> grantedAuthorities =   ((List<String>) realmRoles.get("roles"))
                .stream()
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        System.out.println("Granted authorities: " + grantedAuthorities);

        return grantedAuthorities;
    }
}
