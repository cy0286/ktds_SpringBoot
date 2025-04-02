package com.ktdsuniversity.edu.scy.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.scy.file.dao.FileDao;
import com.ktdsuniversity.edu.scy.file.service.FileService;
import com.ktdsuniversity.edu.scy.file.vo.FileDownloadRequestVO;
import com.ktdsuniversity.edu.scy.file.vo.FileVO;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;
    
    @Override
    public FileVO getOneFile(FileDownloadRequestVO fileDownloadRequestVO) {
    	return this.fileDao.selectOneFile(fileDownloadRequestVO);
    }

}