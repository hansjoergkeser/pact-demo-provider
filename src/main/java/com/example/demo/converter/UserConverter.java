package com.example.demo.converter;

import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Skill;
import com.example.demo.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ashish on 13/5/17.
 */
public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getUserName(), null);
		user.setUserId(userDto.getUserId());
		List<Skill> skills = new LinkedList<>();
		userDto.getSkillDtos().forEach(skillDto -> {
			Skill skill = SkillConverter.dtoToEntity(skillDto);
			skill.setUser(user);
			skills.add(skill);
		});
		user.setSkills(skills);
		return user;
	}

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), null);
		List<SkillDto> skillDtos = new LinkedList<>();
		user.getSkills().forEach(skill -> skillDtos.add(SkillConverter.entityToDto(skill)));
		userDto.setSkillDtos(skillDtos);
		return userDto;
	}
}
