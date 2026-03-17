package com.jsp.ESOP.Service;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.GrantDto;
import com.jsp.ESOP.Entity.GrantEntity;
import com.jsp.ESOP.Repository.GrantEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GrantServiceImpl implements GrantService {

    @Autowired
    private GrantEmpRepository grantEmpRepository;
    @Override
    public AppResponseDto processCreateGrants(List<GrantDto> grants) {

        try {
            List<GrantEntity> list = grants.stream().map(GrantEntity::new).toList();
//            List<GrantEntity> list = grants.stream().map(dto -> {
//                GrantEntity entity = new GrantEntity();
//                entity.setAltKey(generateRandomNumber());
//                entity.setEmpId(dto.getEmpId());
//                entity.setGrantNumber(dto.getGrantNumber());
//                entity.setGrantPrice(dto.getGrantPrice());
//                entity.setFrequency(dto.getFrequency());
//                entity.setPlanId(dto.getPlanId());
//                entity.setCreatedDate(new Date());
//                return entity;
//            }).toList();
            grantEmpRepository.saveAll(list);
            return new AppResponseDto("200", "Null", "Success", list);
        } catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processGetAllGrants() {
        try {
            List<GrantEntity> listOfGrants = grantEmpRepository.findAll();
            return new AppResponseDto("200", "Null", "Success", listOfGrants);
        } catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processGetGrantById(BigInteger id) {

        try {
            Optional<GrantEntity> grant = grantEmpRepository.findById(id);
            return new AppResponseDto("200", "Null", "Success", grant.get());
        } catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processFindByEmp(BigInteger empId) {
      try {
          return new AppResponseDto("200", "Null", "Success", grantEmpRepository.findByEmpId(empId));
      }catch (Exception e) {
          return new AppResponseDto("400", e.getMessage(), "Failure", null);
      }
    }

    @Override
    public AppResponseDto processFindByPlan(BigInteger planId) {
        try {
            return new AppResponseDto("200", "Null", "Success", grantEmpRepository.findByPlanId(planId));
        }catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processFindByPlanIdAndGrantStatusAndAllocationStatus(BigInteger planId, String grantStatus, String allocationStatus) {
       try {
           List<GrantEntity> lists = grantEmpRepository.findByPlanIdAndGrantStatusAndAllocationStatus(planId, grantStatus, allocationStatus);
                return new AppResponseDto("200", "Null", "Success", lists);
       }catch (Exception e) {
           return new AppResponseDto("400", e.getMessage(), "Failure", null);
       }

    }

    @Override
    public AppResponseDto processAcceptGrants(List<BigInteger> list) {
        try {
            int updatedRow = grantEmpRepository.updateIsAcceptedAndAcceptedDate("YES", new Date(),"APPROVED",list);
            if(updatedRow == list.size())
                return new AppResponseDto("200", "Null", "Success", grantEmpRepository.findAllById(list));

            return new AppResponseDto("200", "Null", "Success", updatedRow);
        }catch (Exception e){
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processApprovetGrants(List<BigInteger> list) {
        try {
            int approved = grantEmpRepository.updateGrantStatusAndGrantDate("APPROVED", new Date(), list);
            if(approved == list.size())
                return new AppResponseDto("200", "Null", "Success", grantEmpRepository.findAllById(list));

            return new AppResponseDto("200", "Null", "Success", approved);
        }catch (Exception e){
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }

    @Override
    public AppResponseDto processGetGrantsByPlanId(BigInteger planId) {
        try {
            List<GrantEntity> grantsByPlanId = grantEmpRepository.getGrantsByPlanId(planId);
            return new  AppResponseDto("200", "Null", "Success", grantsByPlanId);
        } catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failure", null);
        }
    }


    private BigInteger generateRandomNumber() {
        return new BigInteger(ThreadLocalRandom.current().nextLong(500, 999999) + "");
    }


}
