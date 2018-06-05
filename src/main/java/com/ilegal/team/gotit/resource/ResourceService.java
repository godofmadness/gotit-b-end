package com.ilegal.team.gotit.resource;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * Created by mm on 6/5/18.
 */
public interface ResourceService {

    void upload(Path path, MultipartFile file) throws StorageException;

}
