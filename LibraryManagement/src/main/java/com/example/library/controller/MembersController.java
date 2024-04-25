package com.example.library.controller;

import com.example.library.config.MembersFeignClient;
import com.example.library.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:4200")
public class MembersController {

    private final MembersFeignClient membersFeignClient;

    @Autowired
    public MembersController(MembersFeignClient membersFeignClient) {
        this.membersFeignClient = membersFeignClient;
    }

    @PostMapping("/create-member")
    public ResponseEntity<Members> createMember(@RequestBody Members member) {
        Members createdMember = membersFeignClient.createMember(member);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @GetMapping("/view-members")
    public ResponseEntity<List<Members>> viewMembers() {
        List<Members> members = membersFeignClient.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @DeleteMapping("/delete-member/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable String id) {
        return membersFeignClient.deleteMember(id);
    }

    @GetMapping("/search-member/{id}")
    public ResponseEntity<Members> searchMemberById(@PathVariable String id) {
        return membersFeignClient.getMemberById(id);
    }
}
