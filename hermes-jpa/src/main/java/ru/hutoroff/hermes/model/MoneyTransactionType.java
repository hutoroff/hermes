package ru.hutoroff.hermes.model;

import javax.persistence.*;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "TRANSACTION_TYPES", schema = "hermes", catalog = "test_db")
public class MoneyTransactionType {
    private short id;
    private String name;
    private Boolean destNeeded;

    @Id
    @Column(name = "ID", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
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
        if (o == null || getClass() != o.getClass()) return false;

        MoneyTransactionType that = (MoneyTransactionType) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (destNeeded != null ? !destNeeded.equals(that.destNeeded) : that.destNeeded != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (destNeeded != null ? destNeeded.hashCode() : 0);
        return result;
    }
}
