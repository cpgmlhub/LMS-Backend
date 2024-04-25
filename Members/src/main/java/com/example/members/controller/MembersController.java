package com.example.members.controller;

import com.example.members.model.Members;
import com.example.members.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/members")
public class MembersController {

    private final MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @PostMapping("/create-member")
    public ResponseEntity<Members> createMember(@RequestBody Members member) {
    	Members createdMember = membersService.createMember(
                member.getName(),
                member.getEmail(),
                member.getDepartment()
            );
            return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
        }

    @GetMapping("/view-members")
    public List<Members> getAllMembers() {
        return membersService.getAllMembers();
    }

    @GetMapping("/search-member/{id}")
    public ResponseEntity<Members> getMemberById(@PathVariable String id) {
        Optional<Members> member = membersService.getMemberById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete-member/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable String id) {
        membersService.deleteMemberById(id);
        return ResponseEntity.ok("Member deleted successfully");
    }
}
