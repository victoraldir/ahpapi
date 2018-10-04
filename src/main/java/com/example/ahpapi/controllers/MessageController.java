package com.example.ahpapi.controllers;

import com.example.ahpapi.entities.Message;
import com.example.ahpapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("messageview")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{tailNumber}")
    public @ResponseBody Page<Message> findByTailNumber(@PathVariable("tailNumber") String tailNumber, Pageable pageable){
        return messageService.findMessagesByTailNumber(tailNumber, pageable);
    }

    @GetMapping
    public @ResponseBody Page<Message> findAll(Pageable pageable){
        return messageService.findAll(pageable);
    }

    @GetMapping("/tailNumbers")
    public @ResponseBody List<String> findTailNumbers(){
        return messageService.findTailNumbers();
    }

}
