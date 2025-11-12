package com.dealerVechileMnagement.service;

import com.dealerVechileMnagement.dto.DealerRequestDto;
import com.dealerVechileMnagement.dto.DealerResponseDto;

public interface DealerService {
	
	 DealerResponseDto saveDealer(DealerRequestDto request);

}
