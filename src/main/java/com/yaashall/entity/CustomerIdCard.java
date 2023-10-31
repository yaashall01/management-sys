package com.yaashall.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @Author Yassine CHALH
 */

@Entity(name = "CustomerIdCard")
@Table(
        name = "customer_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_id_card_number_unique",
                        columnNames = "card_number"
                )
        }
)
public class CustomerIdCard {

    @Id
    @SequenceGenerator(
            name = "customer_id_card_sequence",
            sequenceName = "customer_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_card_sequence"
    )
    @Column(
            name = "card_id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long cardId;

    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customer_id",
            foreignKey = @ForeignKey(
                    name = "customer_id_fk"
            )
    )
    private Customer customer;

    @Column(
            name = "expiration_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDateTime expirationDate;

    public CustomerIdCard(
                          String cardNumber,
                          Customer customer,
                          LocalDateTime expirationDate) {
        this.cardNumber = cardNumber;
        this.customer = customer;
        this.expirationDate = expirationDate;
    }

    public CustomerIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CustomerIdCard(){}

    public Long getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "CustomerIdCard{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", customer=" + customer +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
