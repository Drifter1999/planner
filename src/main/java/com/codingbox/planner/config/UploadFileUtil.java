package com.codingbox.planner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadFileUtil {

    private final Path rootLocation;

    public UploadFileUtil(String imgpath) {
        this.rootLocation = Paths.get(imgpath);
    }


    //temp 이미지들 후기글 이미지 폴더생성후 이동
    public void moveImages(Long blogId, String imgpath) {

        String[] uploadImgs = imgpath.split(",");

        for (int i = 0; i < uploadImgs.length; i++) {
            Path src = Paths.get(rootLocation.toString() + "/blog/temp/" + uploadImgs[i]);
            Path dst = Paths.get(rootLocation.toString() + "/blog/" + blogId + "/" + uploadImgs[i]);

            File noDirectory = new File(rootLocation.toString() + "/blog/" + blogId);
            if (!noDirectory.exists()) {
                noDirectory.mkdirs();
            }
            try {

                Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //이미지폴더 이미지들 temp로 이동(후기)
    public void moveToTemp(Long blogId) {
        File imageDir = new File(rootLocation.toString() + "/blog/" + blogId);

        if (imageDir.exists()) {

            //디렉토리 하위 파일 목록(course.png 제외)
            File[] files = imageDir.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return !name.equals("course.png");
                }
            });

            //Temp로 해당 파일 이동
            if (files != null) {
                for (File file : files) {

                    Path src = Paths.get(rootLocation.toString() + "/blog/" + blogId + "/" + file.getName());
                    Path dst = Paths.get(rootLocation.toString() + "/blog/temp/" + file.getName());
                    try {

                        Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("temp로 파일 이동");
        }
    }



    //후기글 삭제시 이미지삭제
    public void deleteImages(Long blogId) {

        Path path = Paths.get(rootLocation.toString() + "/blog/" + blogId);
        File imageDir = new File(path.toString());

        if (imageDir.exists()) {
            File[] files = imageDir.listFiles();

            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    boolean isDeleted = files[i].delete();
                    if (isDeleted) {
                        System.out.println(i + "번 파일 삭제 성공");
                    }
                }
            }
        }

        try {
            Files.delete(path);
            System.out.println(blogId + "번 이미지 디렉토리 삭제 됨");
        } catch (IOException e) {
            System.out.println(blogId + "번 이미지 디렉토리 삭제 실패");
            e.printStackTrace();
        }
    }


}
