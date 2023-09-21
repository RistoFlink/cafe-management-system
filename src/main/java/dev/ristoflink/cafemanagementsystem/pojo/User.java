package dev.ristoflink.cafemanagementsystem.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")
@NamedQuery(name = "User.getAllUsers", query = "select new dev.ristoflink.cafemanagementsystem.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) from User u where u.role='user'")
@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id")
@NamedQuery(name = "User.getAllAdmin", query = "select u.email from User u where u.role='admin'")

@Component
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
public class User implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "contact_number")
   private String contactNumber;

   @Column(name = "email")
   private String email;

   @Column(name = "password")
   private String password;

   @Column(name = "status")
   private String status;

   @Column(name = "role")
   private String role;

}
