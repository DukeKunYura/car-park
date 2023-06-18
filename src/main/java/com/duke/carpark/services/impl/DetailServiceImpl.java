package com.duke.carpark.services.impl;

import com.duke.carpark.dto.DetailDto;
import com.duke.carpark.entity.Detail;
import com.duke.carpark.mappers.DetailMapper;
import com.duke.carpark.repository.DetailRepository;
import com.duke.carpark.services.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;
    private final DetailMapper detailMapper;

    @Override
    public List<DetailDto> getAllDetails() {
        List<Detail> detailList = detailRepository.findAll();
        return detailMapper.toDtoDetailsList(detailList);
    }

    @Override
    public DetailDto getDetailById(UUID id) {
        Detail detail = detailRepository.findDetailById(id);
        return detailMapper.toDto(detail);
    }

    @Override
    public DetailDto addDetail(DetailDto dto) {
        Detail detail = detailMapper.toEntity(dto);
        Detail newDetail = detailRepository.save(detail);
        return detailMapper.toDto(newDetail);
    }

}
