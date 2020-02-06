package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName="";
    private String partOfContent="";
    private int maxSize;
    private int minSize;
    private List<Path> foundFiles = new ArrayList<Path>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String allLines ="";
        for(int i=0;i<content.length;i++){
            allLines+=(char)content[i];
        }
        boolean checker = true;


        if(this.getMaxSize()!=0&&content.length<getMaxSize()&&!foundFiles.contains(file)){
            checker=true;
        }
        else{
            if(this.getMaxSize()!=0){
                checker=false;
                return super.visitFile(file, attrs);
            }
        }

        if(this.getMinSize()!=0&&content.length>getMinSize()&&!foundFiles.contains(file)){
            checker=true;
        }
        else{
            if(this.getMinSize()!=0){
                checker=false;
                return super.visitFile(file, attrs);
            }
        }

        if(!this.getPartOfContent().equals("") &&allLines.contains(this.getPartOfContent())&&!foundFiles.contains(file)){
            checker=true;
        }
        else{
            if(!this.getPartOfContent().equals("")){
                checker=false;
                return super.visitFile(file, attrs);
            }
        }
        //System.out.println(file.getFileName().toString());
        if(!this.getPartOfName().equals("") &&file.getFileName().toString().contains(this.getPartOfName())&&!foundFiles.contains(file)){
            checker=true;
            //System.out.println("!");
        }
        else{
            if(!this.getPartOfName().equals("")){
                //System.out.println("?");
                checker=false;
                return super.visitFile(file, attrs);
            }
        }
        if(checker){
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
