package ru.hutoroff.hermes.model;

import javax.persistence.*;

/**
 * Created by hutoroff on 05.05.16.
 */
@Entity
@Table(name = "STORAGE_TYPES", schema = "hermes", catalog = "test_db")
public class StorageType {
    private Long id;
    private String name;
    private String comment;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "COMMENT", nullable = true, length = 512)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageType that = (StorageType) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        return getComment() != null ? getComment().equals(that.getComment()) : that.getComment() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        return result;
    }
}
