package com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.entity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.entity.ReservationCheckoutWithdrawal;

@Repository
public interface ReservationCheckoutWithdrawalRepository extends JpaRepository<ReservationCheckoutWithdrawal, Long> {

}
