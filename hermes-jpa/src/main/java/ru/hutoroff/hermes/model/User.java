package ru.hutoroff.hermes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "USERS", schema = "hermes", catalog = "test_db")
public class User {
    private Long id;
    private String login;
    private String password;
    private Date birthDate;
    private String surname;
    private String name;
    private String patronymic;
    private Date createDate;
    private Date changeDate;
    private Group group;
    private List<Storage> storages;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, length = 256, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "SURNAME", nullable = true, length = 128)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PATRONYMIC", nullable = true, length = 128)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHANGE_DATE", nullable = false)
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "GROUP", nullable = false)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getBirthDate() != null ? !getBirthDate().equals(user.getBirthDate()) : user.getBirthDate() != null)
            return false;
        if (getSurname() != null ? !getSurname().equals(user.getSurname()) : user.getSurname() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getPatronymic() != null ? !getPatronymic().equals(user.getPatronymic()) : user.getPatronymic() != null)
            return false;
        if (!getCreateDate().equals(user.getCreateDate())) return false;
        if (getChangeDate() != null ? !getChangeDate().equals(user.getChangeDate()) : user.getChangeDate() != null)
            return false;
        return getGroup().equals(user.getGroup());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        result = 31 * result + getCreateDate().hashCode();
        result = 31 * result + (getChangeDate() != null ? getChangeDate().hashCode() : 0);
        result = 31 * result + getGroup().hashCode();
        return result;
    }
}
