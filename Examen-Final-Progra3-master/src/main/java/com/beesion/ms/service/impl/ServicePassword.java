package com.beesion.ms.service.impl;

import java.time.LocalDate;

import com.beesion.ms.dto.PasswordDto;
import com.beesion.ms.dto.PolicyDomainDto;
import com.beesion.ms.service.IServicePassword;
import com.beesion.ms.util.PasswordGenerator;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicePassword implements IServicePassword {

	@Override
	public PasswordDto generatePassword(PolicyDomainDto policy) {
		String pass = PasswordGenerator.generate(policy);

		PasswordDto password = new PasswordDto();
		password.setPassword(pass);
		password.setCreatedTimestamp(LocalDate.now().toString());

		return password;
	}
}