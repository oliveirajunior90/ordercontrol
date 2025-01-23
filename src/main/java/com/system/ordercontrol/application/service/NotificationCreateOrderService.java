package com.system.ordercontrol.application.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationCreateOrderService {

  private final @Qualifier("notificationService") NotificationService<UUID, byte[]>
      notificationService;

  public NotificationCreateOrderService(NotificationService<UUID, byte[]> notificationService) {
    this.notificationService = notificationService;
  }

  public void notify(UUID orderId, byte[] orderByteArray) {
    notificationService.sendMessage(orderId, orderByteArray);
  }
}
