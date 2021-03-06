package com.koscom.hackathon.domain.user;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column
    private String currentAsset;

    @Column
    private String annualInvest;

    @Column
    private String workingYear;

    @Column
    private String riskTolerance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;  // DB에는 varchar 문자열로 들어가고 JPA에서 꺼낼때는 ENUM으로 매핑이 된다.

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User updateAssetInfo(String currentAsset, String annualInvest, String workingYear, String riskTolerance){
        this.currentAsset = currentAsset;
        this.annualInvest = annualInvest;
        this.workingYear = workingYear;
        this.riskTolerance = riskTolerance;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
