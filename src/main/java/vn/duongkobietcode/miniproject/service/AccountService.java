package vn.duongkobietcode.miniproject.service;

import vn.duongkobietcode.miniproject.domain.Account;

public interface AccountService {
    public Account login(String username, String password);
}
