package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.repository.InsuranceRepository;
import com.wecp.progressive.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurances() throws SQLException {
        return insuranceRepository.findAll();
    }

    @Override
    public int addInsurance(Insurance insurance) throws SQLException {
        return insuranceRepository.save(insurance).getInsuranceId();
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) throws SQLException {
        Insurance i= insuranceRepository.findByInsuranceId(insuranceId);
        if(i==null){
            return null;
        }else{
            return i;
        }
    }

    @Override
    public void updateInsurance(Insurance insurance) throws SQLException {
        insuranceRepository.save(insurance);
    }

    @Override
    public void deleteInsurance(int insuranceId) throws SQLException {
        insuranceRepository.deleteByShipmentId(insuranceId);
    }

}