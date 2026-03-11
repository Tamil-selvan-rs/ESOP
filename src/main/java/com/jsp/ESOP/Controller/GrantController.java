package com.jsp.ESOP.Controller;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.GrantDto;
import com.jsp.ESOP.Service.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class GrantController {
    @Autowired
    private GrantService grantService;

    @PostMapping("/createGrants")
    public @ResponseBody AppResponseDto uploadGrants(@RequestBody List<GrantDto> grants){
        return grantService.processCreateGrants(grants);
    }
    @GetMapping("/findAllGrants")
    public @ResponseBody AppResponseDto findAllGrants(){
       return grantService.processGetAllGrants();
    }
        @GetMapping("/findAllGrant/{id}")
    public @ResponseBody AppResponseDto findGrantById(@PathVariable("id") BigInteger id){
        return grantService.processGetGrantById(id);
    }
    @GetMapping("/findByPlan/{planId}")
    public @ResponseBody AppResponseDto findGrantByPlan(@PathVariable("planId") BigInteger planId){
        return grantService.processFindByPlan(planId);
    }
    @GetMapping("/findByEmp/{empId}")
    public @ResponseBody AppResponseDto findGrantByEmp(@PathVariable("empId") BigInteger empId){
        return grantService.processFindByEmp(empId);
    }
    @GetMapping("/findByPlanIdAndGrantStatusAndAllocationStatus/{planId}/{grantStatus}/{allocationStatus}")
    public AppResponseDto findGrantByEmp(@PathVariable("planId") BigInteger planId,@PathVariable("grantStatus") String grantStatus, @PathVariable("allocationStatus") String allocationStatus ){

        return grantService.processFindByPlanIdAndGrantStatusAndAllocationStatus(planId,grantStatus,allocationStatus);
    }
    @RequestMapping("/approveGrants")
    public AppResponseDto approveGrants(@RequestBody List<BigInteger> list){
        return grantService.processApprovetGrants(list);
    }
    @PutMapping("/acceptGrants")
    public AppResponseDto acceptGrants(@RequestBody List<BigInteger> list){
        return grantService.processAcceptGrants(list);
    }
    @GetMapping("/getGrantsByPlanId/{planId}")
    public @ResponseBody AppResponseDto getGrants(@PathVariable BigInteger planId){
       return grantService.processGetGrantsByPlanId(planId);
    }

}
