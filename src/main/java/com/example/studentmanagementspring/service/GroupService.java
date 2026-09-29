package com.example.studentmanagementspring.service;


import com.example.studentmanagementspring.dto.GroupPatchRequest;
import com.example.studentmanagementspring.dto.GroupRequest;
import com.example.studentmanagementspring.dto.GroupResponse;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.exception.GroupNotFoundException;
import com.example.studentmanagementspring.mapper.GroupMapper;
import com.example.studentmanagementspring.mapper.StudentMapper;
import com.example.studentmanagementspring.model.Group;
import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.repository.GroupRepository;
import com.example.studentmanagementspring.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
	
	private final GroupRepository groupRepository;
	private final GroupMapper groupMapper;
	private final StudentMapper studentMapper;
	private final StudentRepository studentRepository;
	
	public GroupService(GroupRepository groupRepository, GroupMapper groupMapper, GroupRequest groupRequest, StudentMapper studentMapper, StudentRepository studentRepository) {
		this.groupRepository = groupRepository;
		this.groupMapper = groupMapper;
		this.studentMapper = studentMapper;
		this.studentRepository = studentRepository;
	}
	
	public GroupResponse createGroup(GroupRequest groupRequest) {
		
		return groupMapper.toResponse(
			groupRepository.save(
					groupMapper.toEntity(groupRequest)
			)
		);
	}
	
	public List<GroupResponse> getAllGroups() {
		
		List<Group> groups = groupRepository.findAll();
		List<GroupResponse> groupResponses = new ArrayList<>();
		
		for (Group group : groups) {
			groupResponses.add(groupMapper.toResponse(group));
		}
		
		return groupResponses;
	}
	
	public GroupResponse getGroupById(Integer groupId) {
		Group group;
		group = groupRepository.findById(groupId).orElseThrow(
				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
		);
		
		return groupMapper.toResponse(group);
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
	
	public GroupResponse updateGroupById(Integer groupId, GroupRequest groupRequest) {
		Group group = groupRepository.findById(groupId).orElseThrow(
				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
		);
		
		groupMapper.updateEntity(group, groupRequest);
		
		return groupMapper.toResponse(groupRepository.save(group));
	}
	
	public GroupResponse patchGroupById(Integer groupId, GroupPatchRequest patchRequest) {
		
		Group group = groupRepository.findById(groupId).orElseThrow(
				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
		);
		
		groupMapper.patchEntity(group, patchRequest);
		
		return groupMapper.toResponse(groupRepository.save(group));
	}
	
//	public List<StudentResponse> getStudentsFromGroup(Integer groupId) {
//
//		Group group = groupRepository.findById(groupId).orElseThrow(
//				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
//		);
//
//		return group.getStudents().stream()
//				.map(studentMapper::toResponse)
//				.collect(Collectors.toList());
//	}
	
	public Page<StudentResponse> getStudentsFromGroup(Integer groupId, Pageable pageable) {
		
		Group group = groupRepository.findById(groupId).orElseThrow(
				() -> new GroupNotFoundException("Group with id " + groupId + " not found")
		);
		
		Page<Student> students = studentRepository.findStudentsByGroup(group, pageable);
		
		return students.map(studentMapper::toResponse);
	}
}
