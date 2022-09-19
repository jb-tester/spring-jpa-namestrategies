package com.mytests.spring.springDataNameStrategies;

import javax.persistence.*;
import java.util.Objects;

/**
 * *
 * <p>Created by irina on 9/14/2022.</p>
 * <p>Project: spring-jpa-namestrategies</p>
 * *
 */
@Entity
@Table(name = "tab3", schema = "jbtests")
public class Tab3Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "name")
    private String name;


    // the table field with CamelCase-style name will cause the errors if it
    // - specifies no @Column#name
    // - specifies CamelCase-style @Column#name
    // if the default naming strategy is used.
    // One can either specify the different naming strategies in the application.properties
    // or use the lowcase-only @Column#name value
    @Basic
    //@Column(name = "userId")  // will be ignored with default naming strategies
    @Column(name = "userid")  // should be used with default naming strategies
    private long userId;

    // the table field with underscore can be accessed using
    // - @Column#name == underscore field
    // - @Column#name == CamelCase field
    // - not annotated CamelCase field
    // if the default naming strategy is used.
    // if the explicit not-default one is specified, only first variant works.
    @Basic
    //@Column(name = "carId")  // works when default naming strategy is used, but is shown as not resolved
    @Column(name = "car_id")  // works ok both with default and not-default strategies
    private String carId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tab3Entity that = (Tab3Entity) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name);
    }
}
