package com.luizlacerda.Beneficios.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    public enum Values{
        BASIC(1L),

        ADMIN(2L);

        long roleId;

        Values(long roleid){
            this.roleId = roleid;
        }

        public long getRoleId() {
            return roleId;
        }
    }
}
