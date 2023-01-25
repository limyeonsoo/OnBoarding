package com.sds.mvcOnboarding.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "task")
public
class TaskEntity {

    @Id
    private Integer id;
    private Integer member_id;
    private String content;
    private String status;
    private Long create_date;
    private Long modify_date;

    protected TaskEntity() {
    }

    TaskEntity(
            Integer id,
            Integer member_id,
            String content,
            String status,
            Long create_date,
            Long modify_date
    ) {
        this.id = Objects.requireNonNull(id);
        this.member_id = Objects.requireNonNull(member_id);
        this.content = Objects.requireNonNull(content);
        this.status = Objects.requireNonNull(status);
        this.create_date = Objects.requireNonNull(create_date);
        this.modify_date = Objects.requireNonNull(modify_date);
    }

    public Integer getId() {
        return id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public Long getCreate_date() {
        return create_date;
    }

    public Long getModify_date() {
        return modify_date;
    }
}
