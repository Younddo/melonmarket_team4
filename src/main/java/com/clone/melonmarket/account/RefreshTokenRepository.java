package com.clone.melonmarket.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByAccountEmail(String email);

    void deleteAllByAccountEmail(String email);
}
