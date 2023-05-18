package com.dominika.msjuiceservice.domain;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Juice {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(length=36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
    @Version
    private Long version;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    private String juiceName;
    private String juiceStyle;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    private Integer minOnHand;
    private Integer quantityToBrew;
}
