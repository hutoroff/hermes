package ru.hutoroff.hermes.model;

import javax.persistence.*;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "CURRENCY", schema = "hermes", catalog = "test_db")
public class Currency {
    private Integer id;
    private String shortName;
    private String fullName;
    private Character symbol;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SHORT_NAME", nullable = false, length = 16)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "FULL_NAME", nullable = true, length = 128)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "SYMBOL", nullable = true, length = -1)
    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (!getId().equals(currency.getId())) return false;
        if (!getShortName().equals(currency.getShortName())) return false;
        if (getFullName() != null ? !getFullName().equals(currency.getFullName()) : currency.getFullName() != null)
            return false;
        return getSymbol() != null ? getSymbol().equals(currency.getSymbol()) : currency.getSymbol() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getShortName().hashCode();
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getSymbol() != null ? getSymbol().hashCode() : 0);
        return result;
    }
}
