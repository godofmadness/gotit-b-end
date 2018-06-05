package com.ilegal.team.gotit.resource;

/**
 * Created by mm on 6/5/18.
 */
public class StorageException extends RuntimeException {
    public StorageException(String s) {
        super(s);
    }

    public StorageException(String s, Throwable e) {
        super(s, e);
    }

}
