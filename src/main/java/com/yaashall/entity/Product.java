package com.yaashall.entity;


import jakarta.persistence.*;


@Entity(name = "Product")
@Table(name = "product",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "product_id_unique",
                        columnNames = "product_id"
                )
        }
)
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    @Column(
            name = "product_id",
            updatable = false,
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long productId;

    @Column(
            name = "product_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productName;

    @Column(
            name = "product_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productDescription;

    @Column(
            name = "product_price",
            nullable = false,
            columnDefinition = "DOUBLE PRECISION"
    )
    private String productPrice;

    @Column(
            name = "category",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String category;

    public Product(Long productId,
                   String productName,
                   String productDescription,
                   String productPrice,
                   String category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.category = category;
    }

    public Product(String productName,
                   String productDescription,
                   String productPrice,
                   String category) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.category = category;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
