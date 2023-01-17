package com.sds.mvcOnboarding.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "member")
class MemberEntity {

    @Id
    private Integer id;
    private String name;
    private String nick_name;
    private String email;
    private String password;
    private String role;
    private Long create_date;
    private Long modify_date;

    protected MemberEntity() {
    }

    MemberEntity(
            String name,
            String nick_name,
            String email,
            String password,
            String role,
            Long create_date,
            Long modify_date
    ) {
        this.name = Objects.requireNonNull(name);
        this.nick_name = Objects.requireNonNull(nick_name);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = Objects.requireNonNull(role);
        this.create_date = Objects.requireNonNull(create_date);
        this.modify_date = Objects.requireNonNull(modify_date);
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

    public Long getCreate_date() {
        return create_date;
    }

    public Long getModify_date() {
        return modify_date;
    }
}
