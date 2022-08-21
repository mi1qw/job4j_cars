package com.example.car.validation;

import com.example.car.model.Account;
import com.example.car.service.AccountService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NotExistingAccountValidator implements
        ConstraintValidator<NotExistingAccount, Account> {

    private final AccountService accountService;


    public NotExistingAccountValidator(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void initialize(final NotExistingAccount constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final Account account,
                           final ConstraintValidatorContext context) {
        Optional<Account> acc = accountService.findUserByLogin(account.getLogin());
        if (acc.isPresent()) {
            String template = context.getDefaultConstraintMessageTemplate();
            context
                    .buildConstraintViolationWithTemplate(template)
                    .addPropertyNode("login")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
