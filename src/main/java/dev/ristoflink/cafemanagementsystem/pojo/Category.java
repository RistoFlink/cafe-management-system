package dev.ristoflink.cafemanagementsystem.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

@NamedQuery(name = "Category.getAllCategories", query = "select c from Category c where c.id in (select p.category from Product p where p.status='true')")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "categories")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
