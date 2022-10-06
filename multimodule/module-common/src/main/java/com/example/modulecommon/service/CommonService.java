package com.example.modulecommon.service;

import com.example.modulecommon.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    public String commonService() {
        return "commonService";
    }
}
