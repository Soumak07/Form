package com.source.formapp.repository;

import com.source.formapp.persistence.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {

}
