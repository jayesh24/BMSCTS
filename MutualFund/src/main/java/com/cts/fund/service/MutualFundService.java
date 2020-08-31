package com.cts.fund.service;

import java.util.Optional;

import com.cts.fund.model.MutualFund;

public interface MutualFundService {
	
	MutualFund createFund(MutualFund mutualFund);
	Optional<MutualFund> findById(int id);

}
