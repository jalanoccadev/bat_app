package com.jalanocca.bat_backend.service;

import com.jalanocca.bat_backend.model.dto.GenericResponseDto;
import com.jalanocca.bat_backend.model.dto.ocd.OcdBodyConfig;

public interface OcdService {
    GenericResponseDto createOcdDelivery(Long appId, OcdBodyConfig ocdBodyConfig) throws Exception;
}
