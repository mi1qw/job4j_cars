package com.example.car.controller;

import com.example.car.model.Account;
import com.example.car.service.AccountService;
import com.example.car.validation.ValidationGroupSequence;
import com.example.car.web.UserSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final UserSession session;


    @GetMapping("/signPage")
    public String loginPage(final Model model,
                            final @RequestParam(name = "fail", required = false) Boolean fail) {
        model.addAttribute("fail", fail != null);
        model.addAttribute("account", new Account());
        return "signin";
    }

    @PostMapping("/signIn")
    public String signIn(
            final @Validated(ValidationGroupSequence.class)
            @ModelAttribute("account") Account account,
            final BindingResult bindingResult,
            final Model model) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }
        log.info("{}", account);
        Account newAccount = accountService.add(account);
        newAccount.setLogin(null);
        newAccount.setPassword(null);
        session.setAccount(newAccount);
        return "redirect:/posts";
    }

    @PostMapping("/logIn")
    public String login(final @ModelAttribute Account account) {
        Optional<Account> userDb = accountService.findUserByLoginAndPwd(
                account.getLogin(), account.getPassword()
        );
        if (userDb.isEmpty()) {
            return "redirect:/posts?fail=true";
        }
        Account user = userDb.get();
        user.setPassword(null);
        user.setLogin(null);
        session.setAccount(user);
        return "redirect:/posts";
    }

    @GetMapping("/logout")
    public String logout(final Model model) {
        session.setAccount(null);
        return "redirect:/posts";
    }
}
