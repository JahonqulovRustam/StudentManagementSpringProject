package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.dto.GroupPatchRequest;
import com.example.studentmanagementspring.dto.GroupRequest;
import com.example.studentmanagementspring.dto.GroupResponse;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.service.GroupService;
import com.example.studentmanagementspring.model.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

	private final GroupService groupService;
	private final GroupRequest groupRequest;
	
	public GroupController(GroupService groupService, GroupRequest groupRequest) {
		this.groupService = groupService;
		this.groupRequest = groupRequest;
	}
	
	@PostMapping
	public GroupResponse createGroup(@RequestBody GroupRequest groupRequest) {
		return groupService.createGroup(groupRequest);
	}
	
	@GetMapping
	public List<GroupResponse> getAllGroups() {
		
		return groupService.getAllGroups();
	}
	
	@GetMapping("/{groupId:\\d+}")
	public GroupResponse getGroupById(@PathVariable Integer groupId) {
		
		return groupService.getGroupById(groupId);
	}
	
	@DeleteMapping("/{groupId}")
	public void deleteGroupById(@PathVariable Integer groupId) {
		
		groupService.deleteGroupById(groupId);
	}
	
	@GetMapping("/count")
	public long countGroups() {
		
		return groupService.countGroups();
	}
	
	@PutMapping("{id}")
	public GroupResponse updateGroup(@PathVariable Integer id, @Valid @RequestBody GroupRequest groupRequest) {
		return groupService.updateGroupById(id, groupRequest);
	}
	
	@PatchMapping("{id}")
	public GroupResponse patchGroupById(@PathVariable Integer id, @Valid @RequestBody GroupPatchRequest groupPatchRequest) {
		return groupService.patchGroupById(id, groupPatchRequest);
	}
	
	@GetMapping("{groupId}/students")
	public Page<StudentResponse> getStudentsFromGroup(@PathVariable Integer groupId, Pageable pageable) {
		return groupService.getStudentsFromGroup(groupId, pageable);
	}
}
