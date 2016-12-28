package com.hr.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.dao.MiscDao;
import com.hr.dto.DepartmentDTO;
import com.hr.dto.JobDTO;
import com.hr.model.Department;

@Service
public class MiscServiceImpl implements MiscService {
	
	@Autowired
	private MiscDao m;
	
	@Override
	@Transactional(readOnly=true)
	public List<JobDTO> getJobs() {
		return m.getAllJobs();
	}

	@Override
	@Transactional(readOnly=true)
	public JobDTO getJobDTOByID(String ID) {
		return m.getJobByID(ID);
	}


}
