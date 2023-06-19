package com.example.bai_tap_1.repository.impl;

import com.example.bai_tap_1.model.EmailInbox;
import com.example.bai_tap_1.repository.IEmailInboxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailInboxRepository implements IEmailInboxRepository {
    private static List<EmailInbox> stringMap=new ArrayList<>();
    static {
        stringMap.add(new EmailInbox(1,"Vietnamese",25,true,"Tài, Mai Phước Tài"));
        stringMap.add(new EmailInbox(2,"English",10,false,"John, NewSon John"));
        stringMap.add(new EmailInbox(3,"Chinese",15,false,"Sang, ChungQuo Sang"));
        stringMap.add(new EmailInbox(4,"Japanese",50,false,"Thai, Kimochi Thai"));
    }

    @Override
    public List<EmailInbox> getListEmail() {
        return stringMap;
    }

    @Override
    public EmailInbox findId(Integer id) {
        for (EmailInbox e: stringMap) {
            if (e.getId().equals(id)){
               return e;
            }
        }
        return null;
    }

    @Override
    public void editEmail(EmailInbox emailInbox,Integer id) {
        stringMap.set(id,emailInbox);
    }

    @Override
    public int findIndex(int id) {
        for (int i = 0; i < stringMap.size(); i++) {
            if (stringMap.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
