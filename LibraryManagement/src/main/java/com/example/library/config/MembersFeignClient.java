package com.example.library.config;

import com.example.library.model.Members;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Members", url = "${members.service.url}")
public interface MembersFeignClient {

    @PostMapping("/members/create-member")
    Members createMember(@RequestBody Members member);

    @GetMapping("/members/view-members")
    List<Members> getAllMembers();

    @DeleteMapping("/members/delete-member/{id}")
    ResponseEntity<String> deleteMember(@PathVariable String id);

    @GetMapping("/members/search-member/{id}")
    ResponseEntity<Members> getMemberById(@PathVariable String id);
}
