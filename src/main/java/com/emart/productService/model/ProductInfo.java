package com.emart.productService.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table(value = "productinfo")
public class ProductInfo {

    @PrimaryKeyColumn(name = "productid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int productId;

    @Column("sellingchannel")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String sellingChannel;
    @Column("productclass")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String productClass;
    @Column("category")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String category;
    @Column("productname")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String productName;
    @Column("size")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String size;
    @Column("color")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String color;
    @Column("stock")
    @CassandraType(type = CassandraType.Name.INT)
    private int stock;
    @Column("price")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double price;
}
