package ru.hutoroff.hermes.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "ACCOUNTS", schema = "hermes", catalog = "test_db")
public class Account {
    private Long id;
    private Double value;
    private Date createDate;
    private Date changeDate;
    private User createUser;
    private User changeUser;
    private Storage storage;
    private Currency currency;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "VALUE", nullable = false, precision = 2)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CREATE_USER", nullable = false)
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CHANGE_USER", nullable = true)
    public User getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(User changeUser) {
        this.changeUser = changeUser;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "STORAGE", nullable = false)
    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CURRENCY", nullable = false)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (!getId().equals(account.getId())) return false;
        if (!getValue().equals(account.getValue())) return false;
        if (!getCreateDate().equals(account.getCreateDate())) return false;
        if (getChangeDate() != null ? !getChangeDate().equals(account.getChangeDate()) : account.getChangeDate() != null)
            return false;
        if (!getCreateUser().equals(account.getCreateUser())) return false;
        if (getChangeUser() != null ? !getChangeUser().equals(account.getChangeUser()) : account.getChangeUser() != null)
            return false;
        if (!getStorage().equals(account.getStorage())) return false;
        return getCurrency().equals(account.getCurrency());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getCreateDate().hashCode();
        result = 31 * result + (getChangeDate() != null ? getChangeDate().hashCode() : 0);
        result = 31 * result + getCreateUser().hashCode();
        result = 31 * result + (getChangeUser() != null ? getChangeUser().hashCode() : 0);
        result = 31 * result + getStorage().hashCode();
        result = 31 * result + getCurrency().hashCode();
        return result;
    }
}
