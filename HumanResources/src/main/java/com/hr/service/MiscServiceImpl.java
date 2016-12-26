package com.hr.service;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hr.dao.MiscDao;
import com.hr.dto.DepartmentDTO;
import com.hr.dto.JobDTO;
import com.hr.model.Department;

@Service
public class MiscServiceImpl implements MiscService {
	
	private MiscDao m;
	
	@Override
	public List<JobDTO> getJobs() {
		return m.getAllJobs();
	}

	@Override
	public JobDTO getJobDTOByID(String ID) {
		return m.getJobByID(ID);
	}


}
