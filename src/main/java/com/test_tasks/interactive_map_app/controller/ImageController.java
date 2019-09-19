package com.test_tasks.interactive_map_app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@RequestMapping("/image")
public class ImageController {

    private static final String UPLOADED_FOLDER = "/temp/%d";

    @PostMapping("/upload")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
                                         @RequestParam("propertyId") Long propId) {
        String fileName = storeFile(file, propId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(propId + "/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    private String storeFile(MultipartFile file, Long propId) {
        try {
            Files.createDirectories(Paths.get(String.format(UPLOADED_FOLDER, propId)));
        } catch (IOException e) {
            log.warn("Could not create the directory where the uploaded files will be stored.", e);
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                log.warn("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = Paths.get(String.format(UPLOADED_FOLDER, propId)).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            log.warn("Could not store file " + fileName + ". Please try again!", e);
        }
        return fileName;
    }

    private class UploadFileResponse {
        private String fileName;
        private String fileDownloadUri;
        private String fileType;

        private long size;

        private UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
            this.fileName = fileName;
            this.fileDownloadUri = fileDownloadUri;
            this.fileType = fileType;
            this.size = size;
        }
    }
}
