package com.beesion.ms.service;

import com.beesion.ms.dto.PasswordDto;
import com.beesion.ms.dto.PolicyDomainDto;

public interface IServicePassword {
	
	PasswordDto generatePassword(PolicyDomainDto policy);

}
