package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
    
    private String name;
    
    private String pan;
    
    private String password;
    
    private String contact; 
    
    private String mailId;


}
