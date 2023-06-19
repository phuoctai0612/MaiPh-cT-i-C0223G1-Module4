package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.EmailInbox;

import java.util.List;
import java.util.Map;

public interface IEmailInboxService {
    List< EmailInbox> getListEmail();
    EmailInbox findId(Integer id);
    void editEmail(EmailInbox emailInbox, Integer id);
    int findIndex(int id);
}
