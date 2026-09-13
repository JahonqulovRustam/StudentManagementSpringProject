package com.example.studentmanagementspring.service;


import com.example.studentmanagementspring.exception.GroupNotFoundException;
import com.example.studentmanagementspring.model.Group;
import com.example.studentmanagementspring.repository.GroupRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class GroupService {
	
	private final GroupRepository groupRepository;
	
	public GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
	
	public Group createGroup(Group group) {
		
		return groupRepository.save(group);
	}
	
	public List<Group> getAllGroups() {
		return groupRepository.findAll();
	}
	
	public Group getGroupById(Integer groupId) {
		return groupRepository.findById(groupId).orElseThrow(
				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
		);
	}
	
	public void deleteGroupById(Integer groupId) {
		if (!groupRepository.existsById(groupId)) {
			throw new GroupNotFoundException(
					"Group with id " + groupId + " not found"
			);
		}
		
		groupRepository.deleteById(groupId);
	}
	
	public long countGroups() {
		
		return groupRepository.count();
	}
}
