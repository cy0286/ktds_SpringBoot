package com.ktdsuniversity.edu.scy.file.dao;

import com.ktdsuniversity.edu.scy.file.vo.FileDownloadRequestVO;
import com.ktdsuniversity.edu.scy.file.vo.FileVO;

public interface FileDao {
	public int insertNewFile(FileVO fileVO);
	
	public FileVO selectOneFile(FileDownloadRequestVO fileDownloadRequestVO);
}
