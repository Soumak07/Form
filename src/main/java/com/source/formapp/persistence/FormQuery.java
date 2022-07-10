package com.source.formapp.persistence;

import com.source.formapp.enums.QueryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "queries")
public class FormQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="is_required")
    private Boolean isRequired;

    @Column(name = "query_type")
    @Enumerated(EnumType.STRING)
    private QueryType queryType;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "form", referencedColumnName = "form_id")
    private Form form;
}
