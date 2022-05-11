package application.service;

import application.enums.IceClass;
import application.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VesselService {
    Long createVessel(VesselWrapperDto vesselWrapper, String name, String type,
                      int imo, double dspl, double dwt, double loa, double beam,
                      double height, int gt, int swbt, int rgt, int year, ShipownerDto shipowner,
                      CountryDto country, String eMail, CommercialOperatorDto commercialOperator,
                      TechnicalOperatorDto technicalOperator, IceClass iceClass, Date validFrom, Date validTill);

    List<VesselDto> findAll();

    Optional<VesselDto> findById(Long id);

    Optional<VesselDto> findByName(String name);

    Optional<VesselDto> findByImo(int imo);

    void deleteById(Long id);

    void update(Long id, VesselWrapperDto vesselWrapper, String name, String type,
                int imo, double dspl, double dwt, double loa, double beam,
                double height, int gt, int swbt, int rgt, int year, ShipownerDto shipowner,
                CountryDto country, String eMail, CommercialOperatorDto commercialOperator,
                TechnicalOperatorDto technicalOperator, IceClass iceClass, Date validFrom, Date validTill);
}

