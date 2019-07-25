package com.mobysoft.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@ApiModel(value="TransactionImpl", description="Transaction")
@Entity
@Table(name = "ms_transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionImpl implements Transaction {

    @ApiModelProperty(value = "Transaction primary key")
    @Id
    @Column(name = "transaction_id")
    private String id;

    @ApiModelProperty(value = "Transaction date")
    @Column(name = "date")
    private LocalDate date;

    @ApiModelProperty(value = "Transaction value in pence")
    @Column(name = "pence")
    private long amountInPence;

    @ApiModelProperty(value = "Set of transaction types associated with the transaction")
    @ElementCollection(targetClass = Tag.class)
    @CollectionTable(
            name = "ms_transaction_tags",
            joinColumns = @JoinColumn(name = "transaction_id")
    )
    @Column(name = "tags")
    private Set<Enum<?>> tagsSet;

    public TransactionImpl() {
    }

    public TransactionImpl(String id, LocalDate date, long amountInPence, Set<Enum<?>> tagsSet) {
        this.id = id;
        this.date = date;
        this.amountInPence = amountInPence;
        this.tagsSet = tagsSet;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    @Override
    @Column(name = "transaction_amount")
    public long getTransactionAmountInPence() {
        return amountInPence;
    }

    @Override
    @Column(name = "tags")
    public Set<Enum<?>> getTags() {
        return tagsSet;
    }

    @Override
    public boolean hasTag(Enum<?> tag) {
        return tagsSet.contains(tag);
    }

}
