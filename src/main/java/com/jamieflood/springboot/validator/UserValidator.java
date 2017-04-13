package com.jamieflood.springboot.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jamieflood.springboot.model.User;
import com.jamieflood.springboot.service.UserService;

@Component
public class UserValidator implements Validator {

	private final Logger logger = LoggerFactory.getLogger(UserValidator.class);

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {

		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		logger.info("Validating the user object");
		User user = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			logger.error("Username length incorrect");
			errors.rejectValue("username", "Size.userForm.username");
		}
		
		if (userService.findByUsername(user.getUsername()) != null) {
			logger.error("User already exists");
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		EmailValidator validator = EmailValidator.getInstance();
		if (user.getEmail().isEmpty() || !validator.isValid(user.getEmail())) {
			logger.error("No email entered");
			errors.rejectValue("email", "Email.userForm.email");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			logger.error("Password length incorrect");
			errors.rejectValue("password", "Size.userForm.password");
		}
		
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			logger.error("Passwords are not the same");
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}
}
