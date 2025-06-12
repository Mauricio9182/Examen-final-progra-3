package com.beesion.ms.test.service.impl;

import java.time.LocalDate;

import com.beesion.ms.test.dto.PasswordDto;
import com.beesion.ms.test.dto.PolicyDomainDto;
import com.beesion.ms.test.service.IServicePassword;
import com.beesion.ms.test.util.PasswordGenerator;

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