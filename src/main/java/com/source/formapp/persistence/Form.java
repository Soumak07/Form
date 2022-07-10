package com.source.formapp.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "form_details")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long form_id;

    @Column(name="title")
    private String formTitle;

    @Column(name = "is_accepting")
    private Boolean isAccepting;

    @Column(name = "version")
    private Integer version;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn = new Date(System.currentTimeMillis());

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormQuery> formQueryList = new ArrayList<>();

    public void addFormQuery(FormQuery formQuery){
        formQuery.setForm(this);
        this.getFormQueryList().add(formQuery);
    }
}
