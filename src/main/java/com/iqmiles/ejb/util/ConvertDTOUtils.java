/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqmiles.ejb.util;

import com.iqmiles.ejb.dto.GlobalBalanceDto;
import com.iqmiles.ejb.dto.PrivateContributorDto;
import com.iqmiles.ejb.dto.UserDto;
import com.iqmiles.ejb.model.GlobalBalance;
import com.iqmiles.ejb.model.PrivateContributor;
import com.iqmiles.ejb.model.User;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


/**
 *
 * @author rgarcia
 */
public class ConvertDTOUtils {
    
    private ModelMapper modelMapper ;

    public ConvertDTOUtils() {
        modelMapper = new ModelMapper();
    }


    public UserDto createUserDTO(User user){
        UserDto dto = modelMapper.map(user, UserDto.class);
        dto.setPassword("");
        return dto;
    }
    
    public User createUser(UserDto dto){
        return modelMapper.map(dto, User.class);
    }
    
    public List<UserDto> getUsersDto(List<User> users)
    {	
    	return users.stream().map(this::createUserDTO).collect(Collectors.toList());

    }
    
    public List<User> getUsers(List<UserDto> users)
    {
    	return users.stream().map(this::createUser).collect(Collectors.toList());
    }
    
    public GlobalBalanceDto createGlobalBalanceDTO(GlobalBalance globalBalance){
        GlobalBalanceDto dto = modelMapper.map(globalBalance, GlobalBalanceDto.class);
        return dto;
    }
    
    public GlobalBalance createUser(GlobalBalanceDto dto){
        
        return modelMapper.map(dto, GlobalBalance.class);
    }  
    
    public PrivateContributorDto createPrivateContributorDTO(PrivateContributor entity){
        PrivateContributorDto dto = modelMapper.map(entity, PrivateContributorDto.class);
        return dto;
    }
    
    public PrivateContributor createPrivateContributor(PrivateContributorDto dto){
        
        return modelMapper.map(dto, PrivateContributor.class);
    }
    
    public List<PrivateContributorDto> getPrivateContributorsDto(List<PrivateContributor> entities)
    {	
    	return entities.stream().map(this::createPrivateContributorDTO).collect(Collectors.toList());

    }
    
    public List<PrivateContributor> getPrivateContributors(List<PrivateContributorDto> dtos)
    {
    	return dtos.stream().map(this::createPrivateContributor).collect(Collectors.toList());
    }    
}
