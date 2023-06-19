package com.example.bai_tap_1.service.impl;

import com.example.bai_tap_1.model.EmailInbox;
import com.example.bai_tap_1.repository.IEmailInboxRepository;
import com.example.bai_tap_1.service.IEmailInboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmailInboxService implements IEmailInboxService {
    @Autowired
    private IEmailInboxRepository emailInboxRepository;

    @Override
    public List<EmailInbox> getListEmail() {
        return emailInboxRepository.getListEmail();
    }

    @Override
    public EmailInbox findId(Integer id) {
        return emailInboxRepository.findId(id);
    }

    @Override
    public void editEmail(EmailInbox emailInbox, Integer id) {

        emailInboxRepository.editEmail(emailInbox,id);
    }

    @Override
    public int findIndex(int id) {
        return emailInboxRepository.findIndex(id);
    }
}
