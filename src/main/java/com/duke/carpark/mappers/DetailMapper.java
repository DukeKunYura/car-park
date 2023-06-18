package com.duke.carpark.mappers;

import com.duke.carpark.dto.DetailDto;
import com.duke.carpark.dto.DetailWithoutIdDto;
import com.duke.carpark.entity.Detail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailMapper {
    public DetailDto toDto(Detail detail) {
        DetailDto dto = new DetailDto();
        dto.setId(detail.getId());
        dto.setTitle(detail.getTitle());
        dto.setSerialNumber(detail.getSerialNumber());
        dto.setPrice(detail.getPrice());
        return dto;
    }

    public Detail toEntity(DetailDto dto) {
        Detail detail = new Detail();
        detail.setId(dto.getId());
        detail.setTitle(dto.getTitle());
        detail.setSerialNumber(dto.getSerialNumber());
        detail.setPrice(dto.getPrice());
        return detail;
    }

    public Detail toEntityWithoutId(DetailWithoutIdDto dto) {
        Detail detail = new Detail();
        detail.setTitle(dto.getTitle());
        detail.setSerialNumber(dto.getSerialNumber());
        detail.setPrice(dto.getPrice());
        return detail;
    }

    public List<DetailDto> toDtoDetailsList(List<Detail> details) {
        List<DetailDto> detailsListDto = new ArrayList<>();
        for (Detail detail : details) {
            detailsListDto.add(this.toDto(detail));
        }
        return detailsListDto;
    }
}
