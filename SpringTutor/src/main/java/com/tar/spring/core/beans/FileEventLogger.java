package com.tar.spring.core.beans;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by vitar on 08.03.17.
 */
public class FileEventLogger implements EventLogger {
    private File file;
    private String fileName;

    public FileEventLogger(String fileName){
        this.fileName = fileName;
    }

    public void init(){
        this.file = new File(fileName);
        if(file.exists() && !file.canWrite())
            throw new IllegalArgumentException("Can't write to file");
        else if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw  new IllegalArgumentException("Can't create");
            }
        }
        System.out.println(file.exists());
    }



    public void logEvent(Event msg) {
        file = new File(fileName);
        try {
            FileUtils.writeStringToFile(file, msg.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
