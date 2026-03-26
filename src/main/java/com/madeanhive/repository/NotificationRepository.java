package com.madeanhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {



}
