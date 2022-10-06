package com.example.moduleapi.service;

import com.example.moduleapi.exception.CustomException;
import com.example.modulecommon.domain.Member;
import com.example.modulecommon.enums.CodeEnum;
import com.example.modulecommon.repository.MemberRepository;
import com.example.modulecommon.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private final CommonService commonService;
    private final MemberRepository memberRepository;

    public String save() {
        memberRepository.save(Member.builder()
                .name("name")
                .build());
        log.info(CodeEnum.SUCCESS.getCode());
        log.info(commonService.commonService());
        return "save";
    }

    public String find() {
        long count = memberRepository.count();
        log.info("DB size : {}", count);
        return "find";
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
