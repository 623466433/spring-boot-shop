package cn.sockstack.shop.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    private Integer id;

    private String username;

    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
