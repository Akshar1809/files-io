package com.akshar.Akshar1809_FilesIO;

import java.io.File;
import java.util.ArrayList;

public class Constant {
    public static String[] videoExtensions = {".mp4",".ts",".mkv",".mov",
            ".3gp",".mv2",".m4v",".webm",".mpeg1",".mpeg2",".mts",".ogm",
            ".bup", ".dv",".flv",".m1v",".m2ts",".mpeg4",".vlc",".3g2",
            ".avi",".mpeg",".mpg",".wmv",".asf"};

    public static String[] imageExtensions = {".jpg",".jpeg",".png",".gif"};

    public static String[] applicationExtensions = {".app",".apk"};

    public static String[] audioExtensions = {".mp3"};

    public static String[] documentExtensions = {".txt",".pdf",
            ".ppt",".pptx",".pot",".pptm",".ppsx",".potx",".pps",".xml",".odp",
            ".doc",".docx",".docm",".dotx",".dotm",".dot",
            ".xls",".xlsm",".xlsb",".xlsx",".xltx",".xltm",".csv"
            ,".java",".class",".bat",".htm",".html",".p65",".t65",".c"
            ,".py",".kt",".arff",".psd",".odt",".ods",".prm",".slk",".xps"
            ,".rtf",".css",".js",".tif",};
    

    //all loaded files will be here
    public static ArrayList<File> allImageMediaList = new ArrayList<>();
    public static ArrayList<File> allVideoMediaList = new ArrayList<>();
    public static ArrayList<File> allApplicationMediaList = new ArrayList<>();
    public static ArrayList<File> allAudioMediaList = new ArrayList<>();
    public static ArrayList<File> allDocumentMediaList = new ArrayList<>();
}
