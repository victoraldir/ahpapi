package com.example.ahpapi.services;

import com.example.ahpapi.entities.Message;
import com.example.ahpapi.repositories.MessageCorrelatedRepository;
import com.example.ahpapi.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageCorrelatedRepository messageCorrelatedRepository;

    public Page<Message> findMessagesByTailNumber(String tailNumber, Pageable Pageable){

        Page<Message> messageList = messageRepository.findByTailNumber(tailNumber, Pageable);

        enrichCorrelatedMessage(messageList);

        return messageList;
    }

    private Page<Message> enrichCorrelatedMessage(Page<Message> messageList){
        messageList.stream().filter(message -> message.getMmIdList() != null).forEach(message -> {
            List<Long> longs = parseToListLong(message.getMmIdList());
            message.setMaintMessage(messageCorrelatedRepository.findByMMIdList(longs));
        });

        return messageList;
    }

    private List<Long> parseToListLong(String stringCommaSeparated){

        List<String> stringList = Arrays.asList(stringCommaSeparated.split(","));
        return stringList.stream().map(s -> new Long(s.trim())).collect(Collectors.toList());
    }

    public Page<Message> findAll(Pageable Pageable){

        Page<Message> messageList = messageRepository.findAll(Pageable);

        enrichCorrelatedMessage(messageList);

        return messageList;
    }


    public List<String> findTailNumbers(){
        return messageRepository.findTailNumbers();
    }
}
