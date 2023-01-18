package com.sds.mvcOnboarding.domain;

import java.util.Objects;

public class Member {
    private final int id;
    private final String name;
    private final String nick_name;
    private final String email;
    private final String password;
    private final String role;
    private final long create_date;
    private final long modify_date;

    public Member(
            Integer id,
            String name,
            String nick_name,
            String email,
            String password,
            String role,
            long create_date,
            long modify_date
    ) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.nick_name = Objects.requireNonNull(nick_name);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = Objects.requireNonNull(role);
        this.create_date = create_date;
        this.modify_date = modify_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public long getCreate_date() {
        return create_date;
    }

    public long getModify_date() {
        return modify_date;
    }
}
