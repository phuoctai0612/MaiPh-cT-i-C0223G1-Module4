package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.model.EmailInbox;

import java.util.List;
import java.util.Map;

public interface IEmailInboxRepository {
    List< EmailInbox> getListEmail();
    EmailInbox findId(Integer id);
    void editEmail(EmailInbox emailInbox,Integer id);
    int findIndex(int id);
}
