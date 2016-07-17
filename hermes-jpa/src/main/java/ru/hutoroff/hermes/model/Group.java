package ru.hutoroff.hermes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "GROUPS", schema = "hermes", catalog = "test_db")
public class Group {
    private Long id;
    private String name;
    private String formalName;
    private Date createDate;
    private Date changeDate;
    private List<User> users;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 128, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "formal_name", nullable = true, length = 1024)
    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "change_date", nullable = true)
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group",
                cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!getId().equals(group.getId())) return false;
        if (!getName().equals(group.getName())) return false;
        if (getFormalName() != null ? !getFormalName().equals(group.getFormalName()) : group.getFormalName() != null)
            return false;
        if (!getCreateDate().equals(group.getCreateDate())) return false;
        if (getChangeDate() != null ? !getChangeDate().equals(group.getChangeDate()) : group.getChangeDate() != null)
            return false;
        return getUsers() != null ? getUsers().equals(group.getUsers()) : group.getUsers() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getFormalName() != null ? getFormalName().hashCode() : 0);
        result = 31 * result + getCreateDate().hashCode();
        result = 31 * result + (getChangeDate() != null ? getChangeDate().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }
}
