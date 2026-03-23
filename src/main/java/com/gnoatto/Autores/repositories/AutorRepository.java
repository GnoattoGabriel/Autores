package com.gnoatto.Autores.repositories;

import com.gnoatto.Autores.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
