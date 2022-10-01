package com.example.car.web;

import com.example.car.model.Account;
import com.example.car.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@Component
@RequestScope
@Slf4j
@AllArgsConstructor
public class ReqSqope {
    private final AccountService accountService;
    private final UserSession userSession;

    public void register(final Account account) {
        Account newAccount = accountService.add(account);
        newAccount.setLogin(null);
        newAccount.setPassword(null);
        userSession.setAccount(newAccount);
    }

    public boolean login(final Account account) {
        Optional<Account> userDb = accountService.findUserByLoginAndPwd(
                account.getLogin(), account.getPassword()
        );
        if (userDb.isEmpty()) {
            return false;
        }
        Account user = userDb.get();
        user.setPassword(null);
        user.setLogin(null);
        userSession.setAccount(user);
        return true;
    }
}
