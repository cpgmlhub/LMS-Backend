package com.example.members.service;

import com.example.members.model.Members;
import com.example.members.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    @Autowired
    public MembersServiceImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public Members createMember(String name, String email, String department) {
    	long memberCount = membersRepository.count();
        String memberId = generateId(memberCount); // Generate member ID
        Members member = new Members();
        member.setId(memberId); // Set the generated ID
        member.setName(name);
        member.setEmail(email);
        member.setDepartment(department);
        return membersRepository.save(member);
    }

    @Override
    public Long getNextMemberCountFromDatabase() {
    	long memberCount = membersRepository.count();
         // Increment the count by 1 for the next ID
        return memberCount + 1;
    }

    @Override
    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteMemberById(String id) {
        membersRepository.deleteById(id);
    }

    @Override
    public Optional<Members> getMemberById(String id) {
        return membersRepository.findById(id);
    }

    // Method to generate ID for members
    private String generateId(long memberCount) {
        char firstChar = 'M'; // Always use 'M' as the first character for members
        // Format the running numbers to have leading zeros (e.g., "0001")
        String runningNumbers = String.format("%04d", memberCount + 1); // Increment count by 1 for the next ID
        // Concatenate the first character and running numbers
        return firstChar + runningNumbers;
    }
    
    
}
