package com.coderscampus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.api.domain.ContactMessage;

public interface ContactMessageRepository extends JpaRepository <ContactMessage,Long> {

}
