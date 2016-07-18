package ru.hutoroff.hermes.model;

import javax.persistence.*;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "TRANSACTION_TYPES", schema = "hermes", catalog = "test_db")
public class MoneyTransactionType {
    private Integer id;
    private String name;
    private Boolean destNeeded;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Basic
    @Column(name = "DEST_NEEDED", nullable = false)
    public Boolean getDestNeeded() {
        return destNeeded;
    }

    public void setDestNeeded(Boolean destNeeded) {
        this.destNeeded = destNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoneyTransactionType)) return false;

        MoneyTransactionType that = (MoneyTransactionType) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        return getDestNeeded().equals(that.getDestNeeded());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDestNeeded().hashCode();
        return result;
    }
}
