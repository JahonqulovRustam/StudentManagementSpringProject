package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.service.GroupService;
import com.example.studentmanagementspring.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

	private final GroupService groupService;
	
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@PostMapping
	public Group createGroup(@RequestBody Group group) {
		return groupService.createGroup(group);
	}
	
	@GetMapping
	public List<Group> getAllGroups() {
		
		return groupService.getAllGroups();
	}
	
	@GetMapping("/{groupId:\\d+}")
	public Group getGroupById(@PathVariable Integer groupId) {
		
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
}
