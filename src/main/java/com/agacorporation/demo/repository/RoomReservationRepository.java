package com.agacorporation.demo.repository;

import com.agacorporation.demo.domain.RoomReservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface RoomReservationRepository
       extends JpaRepository<RoomReservation, Long>, JpaSpecificationExecutor<RoomReservation>
{
    // ім'я методу також є запитом
    // Сторінка <RoomReservation> findByNameContaining (String phrase, Pageable pageable);

    // над класом Vehicle є визначення запиту (@NamedQuery), пов'язане з цим методом
    // Сторінка <RoomReservation> findAllRoomReservationsUsingNamedQuery(String phrase, Pageable pageable);

    @Query("SELECT v FROM RoomReservation v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "upper(v.user.firstName) LIKE upper(:phrase) OR " +
            "upper(v.user.lastName) LIKE upper(:phrase) OR " +
            "upper(v.user.login) LIKE upper(:phrase) )"


    )
    Page<RoomReservation> findAllRoomReservationsUsingFilter(@Param("phrase") String p, Pageable pageable);

    @Query("SELECT v FROM RoomReservation v WHERE " +
            "(" +
            ":phrase is null OR :phrase = '' OR "+
            "v.user.login LIKE (:phrase) )"

    )
    Page<RoomReservation> findUserRoomReservations(@Param("phrase") String p, Pageable pageable);


}
