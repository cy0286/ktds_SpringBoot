package com.ktdsuniversity.edu.scy.file.service;

import com.ktdsuniversity.edu.scy.file.vo.FileDownloadRequestVO;
import com.ktdsuniversity.edu.scy.file.vo.FileVO;

public interface FileService {

	public FileVO getOneFile(FileDownloadRequestVO fileDownloadRequestVO);
}