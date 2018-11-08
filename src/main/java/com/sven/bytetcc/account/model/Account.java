package com.sven.bytetcc.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.annotation.Generated;

@Entity
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double availableAmount;

    private double lockedAmount;

    public Account()
    {

    }

    @Generated("SparkTools")
    private Account(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.availableAmount = builder.availableAmount;
        this.lockedAmount = builder.lockedAmount;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getAvailableAmount()
    {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount)
    {
        this.availableAmount = availableAmount;
    }

    public double getLockedAmount()
    {
        return lockedAmount;
    }

    public void setLockedAmount(double lockedAmount)
    {
        this.lockedAmount = lockedAmount;
    }

    /**
     * Creates builder to build {@link Account}.
     * 
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder to build {@link Account}.
     */
    @Generated("SparkTools")
    public static final class Builder
    {
        private long id;
        private String name;
        private double availableAmount;
        private double lockedAmount;

        private Builder()
        {
        }

        public Builder withId(long id)
        {
            this.id = id;
            return this;
        }

        public Builder withName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder withAvailableAmount(double availableAmount)
        {
            this.availableAmount = availableAmount;
            return this;
        }

        public Builder withLockedAmount(double lockedAmount)
        {
            this.lockedAmount = lockedAmount;
            return this;
        }

        public Account build()
        {
            return new Account(this);
        }
    }

}
