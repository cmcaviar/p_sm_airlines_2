package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.AircraftRestController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDTO;
import ru.kataproject.p_sm_airlines_1.service.AircraftService;
import ru.kataproject.p_sm_airlines_1.util.mapper.AircraftMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AircraftRestControllerImpl implements AircraftRestController {

    private final AircraftService aircraftService;
    private final AircraftMapper aircraftMapper;

    @Override
    public List<AircraftDTO> getAllAircrafts() {
        return aircraftService.getAllAircrafts().stream().map(aircraftMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AircraftDTO getAircraftById(@PathVariable final Long id) {
        return aircraftMapper.convertToDTO(aircraftService.getAircraftById(id));
    }

    @Override
    public AircraftDTO saveAircraft(@RequestBody final AircraftDTO aircraftDTO) {
        aircraftService.saveAircraft(aircraftMapper.convertToEntity(aircraftDTO));
        return aircraftDTO;
    }

    @Override
    public AircraftDTO updateAircraft(@RequestBody final AircraftDTO aircraftDTO) {
        aircraftService.updateAircraft(aircraftMapper.convertToEntity(aircraftDTO));
        return aircraftDTO;
    }

    @Override
    public void deleteAircraft(@PathVariable final Long id) {
        aircraftService.deleteAircraft(id);
    }
}
