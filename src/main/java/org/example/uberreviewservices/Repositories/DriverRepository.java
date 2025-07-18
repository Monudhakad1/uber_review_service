package org.example.uberreviewservices.Repositories;

import org.example.uberreviewservices.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    List<Driver> findAllByIdIn(List<Long> driverIds);

    @Query(nativeQuery = true , value="SELECT * FROM driver WHERE id= :id AND license_number= :licenseNumber ")
    Optional<Driver> rawFindByIdAndDrivingLicense(Long id , String licenseNumber);

}
