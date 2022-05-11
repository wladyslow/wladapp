package application.converter.impl;


import application.converter.StringToShipperDtoConverter;
import application.dto.ShipperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringToShipperConverterImpl implements StringToShipperDtoConverter {

    @Override
    public ShipperDto convert(String arg0) {
        return null;
    }
}
