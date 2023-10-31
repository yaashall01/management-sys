package com.yaashall.entity;


import jakarta.persistence.*;

@Entity(name = "Service")
@Table(name = "service",
    uniqueConstraints = {
                @UniqueConstraint(name = "service_id_unique", columnNames = "service_id")
        })
public class Service {


    @Id
    @SequenceGenerator(
            name = "service_id_sequence",
            sequenceName = "service_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_id_sequence"
    )
    @Column(
            name = "service_id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long serviceId;

    @Column(
            name = "service_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String serviceName;

    @Column(
            name = "service_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String serviceDescription;

    @Column(
            name = "service_price",
            nullable = false,
            columnDefinition = "DOUBLE PRECISION"
    )
    private String servicePrice;

    @Column(
            name = "available",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String available;

    public Service(Long serviceId, String serviceName, String serviceDescription, String servicePrice, String available) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.available = available;
    }

    public Service(String serviceName, String serviceDescription, String servicePrice, String available) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.available = available;
    }

    public Service() {
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", servicePrice='" + servicePrice + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
