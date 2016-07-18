package ru.hutoroff.hermes.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "TRANSACTIONS", schema = "hermes", catalog = "test_db")
public class MoneyTransaction {
    private Long id;
    private Double value;
    private Date createDate;
    private Date changeDate;
    private String comment;
    private MoneyTransactionType type;
    private User owner;
    private User changeUser;
    private Account account;
    private Account destination;

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "TYPE", nullable = false)
    public MoneyTransactionType getType() {
        return type;
    }

    public void setType(MoneyTransactionType type) {
        this.type = type;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "OWNER", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "change_user")
    public User getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(User changeUser) {
        this.changeUser = changeUser;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "ACCOUNT", nullable = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "DESTINATION")
    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoneyTransaction)) return false;

        MoneyTransaction that = (MoneyTransaction) o;

        if (!getId().equals(that.getId())) return false;
        if (!getValue().equals(that.getValue())) return false;
        if (!getCreateDate().equals(that.getCreateDate())) return false;
        if (getChangeDate() != null ? !getChangeDate().equals(that.getChangeDate()) : that.getChangeDate() != null)
            return false;
        if (getComment() != null ? !getComment().equals(that.getComment()) : that.getComment() != null) return false;
        if (!getType().equals(that.getType())) return false;
        if (!getOwner().equals(that.getOwner())) return false;
        if (getChangeUser() != null ? !getChangeUser().equals(that.getChangeUser()) : that.getChangeUser() != null)
            return false;
        if (!getAccount().equals(that.getAccount())) return false;
        return getDestination() != null ? getDestination().equals(that.getDestination()) : that.getDestination() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getCreateDate().hashCode();
        result = 31 * result + (getChangeDate() != null ? getChangeDate().hashCode() : 0);
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        result = 31 * result + getType().hashCode();
        result = 31 * result + getOwner().hashCode();
        result = 31 * result + (getChangeUser() != null ? getChangeUser().hashCode() : 0);
        result = 31 * result + getAccount().hashCode();
        result = 31 * result + (getDestination() != null ? getDestination().hashCode() : 0);
        return result;
    }
}
