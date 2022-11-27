package ru.kataproject.p_sm_airlines_1.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class AircraftRestControllerImpl implements AircraftRestController {

    private final AircraftService aircraftService;
    private final AircraftMapper aircraftMapper;

    @Override
    public List<AircraftDTO> getAllAircrafts() {
        log.info("getAllAircrafts()");
        return aircraftService.getAllAircrafts().stream().map(aircraftMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AircraftDTO getAircraftById(@PathVariable final Long id) {
        log.info("getAircraftById() with id = " + id);
        return aircraftMapper.convertToDTO(aircraftService.getAircraftById(id));
    }

    @Override
    public AircraftDTO saveAircraft(@RequestBody final AircraftDTO aircraftDTO) {
        log.info("saveAircraft()");
        aircraftService.saveAircraft(aircraftMapper.convertToEntity(aircraftDTO));
        return aircraftDTO;
    }

    @Override
    public AircraftDTO updateAircraft(@RequestBody final AircraftDTO aircraftDTO) {
        log.info("updateAircraft() with id = " + aircraftDTO.getId());
        aircraftService.updateAircraft(aircraftMapper.convertToEntity(aircraftDTO));
        return aircraftDTO;
    }

    @Override
    public void deleteAircraft(@PathVariable final Long id) {
        log.info("deleteAircraft() with id = " + id);
        aircraftService.deleteAircraft(id);
    }
}
