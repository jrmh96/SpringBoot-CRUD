package com.hr.service;

import java.util.List;
import com.hr.dto.*;
import com.hr.model.Department;

public interface MiscService {
	List<JobDTO> getJobs();
	
	JobDTO getJobDTOByID(String ID);
	
}

