package com.gonzalo.u4p3.repositorio;

import com.gonzalo.u4p3.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ActividadRepositorio extends JpaRepository<Actividad, Long>{

    /**Al usar JpaRepository, esto hace que heredemos las funciones de findall y save.
    Asi que no hace falta ningun metodo de momento.*/

}
