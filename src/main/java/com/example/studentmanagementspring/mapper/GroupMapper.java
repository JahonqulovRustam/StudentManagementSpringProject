package com.example.studentmanagementspring.mapper;

import com.example.studentmanagementspring.dto.GroupPatchRequest;
import com.example.studentmanagementspring.dto.GroupRequest;
import com.example.studentmanagementspring.dto.GroupResponse;
import com.example.studentmanagementspring.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
	
	public GroupResponse toResponse(Group group) {
		GroupResponse groupResponse = new GroupResponse();
		
		groupResponse.setId(group.getId());
		groupResponse.setName(group.getName());
		
		return groupResponse;
	}
	
	public Group toEntity(GroupRequest groupRequest) {
		Group group = new Group();
		
		group.setName(groupRequest.getName());
		
		return group;
	}
	
	public void updateEntity(Group group, GroupRequest groupRequest) {
		
		group.setName(groupRequest.getName());
	}
	
	public void patchEntity(Group group, GroupPatchRequest groupPatchRequest) {
		
		if (groupPatchRequest.getName() != null) {
			group.setName(groupPatchRequest.getName());
		}
	}
}
