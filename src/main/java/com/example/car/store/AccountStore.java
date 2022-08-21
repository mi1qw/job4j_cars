package com.example.car.store;

import com.example.car.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountStore extends CrudPersist<Account> {

    public AccountStore() {
        super(Account.class);
    }

    /**
     * Return Account By Login And password.
     *
     * @param login    login
     * @param password password
     * @return Optional Account
     */
    public Optional<Account> findUserByLoginAndPwd(final String login, final String password) {
        return tx(session -> {
            try {
                Account account = session.createQuery(
                                "from Account a where a.login=:login and "
                                + "a.password=:password",
                                Account.class)
                        .setParameter("login", login)
                        .setParameter("password", password)
                        .uniqueResult();
                return account != null ? Optional.of(account) : Optional.empty();
            } catch (Exception e) {
                throw new IllegalStateException();
            }
        });
    }

    /**
     * find User By Login.
     *
     * @param login login
     * @return Optional Account
     */
    public Optional<Account> findUserByLogin(final String login) {
        return tx(session -> {
            try {
                Account account = session.createQuery(
                                "from Account a where a.login=:login", Account.class)
                        .setParameter("login", login)
                        .uniqueResult();
                return account != null ? Optional.of(account) : Optional.empty();
            } catch (Exception e) {
                throw new IllegalStateException();
            }
        });
    }
}
