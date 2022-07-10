package com.source.formapp.repository;

import com.source.formapp.persistence.FormQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormQueryRepository extends JpaRepository<FormQuery, Long> {
}
