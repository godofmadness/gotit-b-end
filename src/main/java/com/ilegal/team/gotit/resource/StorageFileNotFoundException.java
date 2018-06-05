package com.ilegal.team.gotit.resource;

/**
 * Created by mm on 6/5/18.
 */

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
