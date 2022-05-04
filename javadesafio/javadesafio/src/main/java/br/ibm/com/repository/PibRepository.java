package br.ibm.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ibm.com.entity.PibEntity;

import java.util.Date;
import java.util.List;

public interface PibRepository extends JpaRepository<PibEntity, Long> {


    List<PibEntity> findByData(Date data);

    List<PibEntity> findByDataBetween(Date startDate, Date endDate);

    @Query(
            value = "SELECT * FROM tb_divida WHERE data Like %?1%",
            nativeQuery = true)
    List<PibEntity> findByYear(@Param ("data") String year);

    @Query(
            value = "SELECT * FROM tb_divida WHERE valor = :valor",
            nativeQuery = true)
    List<PibEntity> findByValor2(Double valor);

    List<PibEntity> findByValor(Double valor);

}	 

