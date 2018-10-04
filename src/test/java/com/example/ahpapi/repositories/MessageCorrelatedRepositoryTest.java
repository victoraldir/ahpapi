package com.example.ahpapi.repositories;

import com.example.ahpapi.entities.MessageCorrelated;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class MessageCorrelatedRepositoryTest {

    @Autowired
    private MessageCorrelatedRepository messageCorrelatedRepository;

    @Test
    public void shouldFetchMessages(){
    }

}