package ru.mlg.probe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mlg.probe.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
