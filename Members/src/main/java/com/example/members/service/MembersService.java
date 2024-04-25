package com.example.members.service;

import com.example.members.model.Members;

import java.util.List;
import java.util.Optional;

public interface MembersService {
    Members createMember(String name, String email, String department);

    Long getNextMemberCountFromDatabase();

    List<Members> getAllMembers();

    void deleteMemberById(String id);

    Optional<Members> getMemberById(String id);
}

