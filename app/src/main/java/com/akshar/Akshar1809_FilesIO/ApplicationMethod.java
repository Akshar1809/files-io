package com.akshar.Akshar1809_FilesIO;

import java.io.File;

public class ApplicationMethod {
    public static void load_Directory_Files(File directory){
        File[] fileList = directory.listFiles();
        if(fileList != null && fileList.length > 0){
            for (int i=0; i<fileList.length; i++){
                if(fileList[i].isDirectory()){
                    load_Directory_Files(fileList[i]);
                }
                else {
                    String name = fileList[i].getName().toLowerCase();
                    for (String extension: Constant.applicationExtensions){
                        //check the type of file
                        if(name.endsWith(extension)){
                            Constant.allApplicationMediaList.add(fileList[i]);
                            //when we found file
                            break;
                        }
                    }
                }
            }
        }
    }
}
