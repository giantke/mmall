package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by apple on 2017/12/31.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
