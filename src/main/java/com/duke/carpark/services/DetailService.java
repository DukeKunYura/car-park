package com.duke.carpark.services;

import com.duke.carpark.dto.DetailDto;
import com.duke.carpark.dto.DetailWithoutIdDto;

import java.util.List;
import java.util.UUID;

public interface DetailService {
    List<DetailDto> getAllDetails();

    DetailDto getDetailById(UUID id);

    DetailDto addDetail(DetailWithoutIdDto dto);
}
