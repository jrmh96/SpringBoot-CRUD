package com.hr.service;
import java.util.List;

import com.hr.dao.MiscDao;
import com.hr.dto.DepartmentDTO;
import com.hr.dto.JobDTO;
import com.hr.model.Department;

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
