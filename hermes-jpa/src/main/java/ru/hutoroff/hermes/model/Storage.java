package ru.hutoroff.hermes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "STORAGES", schema = "hermes", catalog = "test_db")
public class Storage {
    private Long id;
    private String name;
    private User owner;
    private Date createDate;
    private User createUser;
    private Date changeDate;
    private User changeUser;
    private String comment;
    private StorageType type;
    private List<Account> accounts;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "OWNER", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CHANGE_DATE", nullable = true)
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Basic
    @Column(name = "COMMENT", nullable = true, length = 1024)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "CREATE_USER", nullable = false)
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    @ManyToOne
    @JoinColumn(name = "CHANGE_USER", nullable = true)
    public User getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(User changeUser) {
        this.changeUser = changeUser;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "TYPE", nullable = false)
    public StorageType getType() {
        return type;
    }

    public void setType(StorageType type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (!getId().equals(storage.getId())) return false;
        if (!getName().equals(storage.getName())) return false;
        if (!getOwner().equals(storage.getOwner())) return false;
        if (!getCreateDate().equals(storage.getCreateDate())) return false;
        if (getChangeDate() != null ? !getChangeDate().equals(storage.getChangeDate()) : storage.getChangeDate() != null)
            return false;
        return getComment() != null ? getComment().equals(storage.getComment()) : storage.getComment() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getOwner().hashCode();
        result = 31 * result + getCreateDate().hashCode();
        result = 31 * result + (getChangeDate() != null ? getChangeDate().hashCode() : 0);
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        return result;
    }
}
