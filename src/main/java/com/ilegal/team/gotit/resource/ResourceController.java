package com.ilegal.team.gotit.resource;

import com.ilegal.team.gotit.atricle.ArticleController;
import com.ilegal.team.gotit.auth.session.SessionService;
import com.ilegal.team.gotit.auth.session.SessionTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

/**
 * Created by mm on 6/5/18.
 */
@RestController
@CrossOrigin(origins = "*")
public class ResourceController {

    private class UploadStatus {
        private int uploaded;
        private String url;
        private String filename;

        public int getUploaded() {
            return uploaded;
        }

        public void setUploaded(int uploaded) {
            this.uploaded = uploaded;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public UploadStatus(int uploaded, String url, String filename) {
            this.uploaded = uploaded;
            this.url = url;
            this.filename = filename;
        }

        public UploadStatus() {
        }
    }


    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);


    @Autowired
    SessionService sessionService;

    @Autowired
    ResourceService resourceService;

    @Value("${storage.fs.rootPath}")
    private String DATA_SOURCE;




    // upload article resource
    @RequestMapping(method = RequestMethod.POST, value = "/gotit/resource/article/{articleId}")
    public ResponseEntity<UploadStatus> handleFileUpload(@RequestParam("upload") MultipartFile file,
                                                 @RequestParam("at") String token,
                                                 @PathVariable("articleId") String articleId) {
        logger.info("auth token " + token);
        // no session case
        SessionTO session = sessionService.findByToken(token);
        if (session == null) {
            return new ResponseEntity<>(new UploadStatus(0, "", ""), HttpStatus.UNAUTHORIZED);
        }

        logger.info("Starting upload of file ", file.getOriginalFilename());
        resourceService.upload(Paths.get(DATA_SOURCE, session.getUserId(), articleId, file.getOriginalFilename()), file);
        // find current session

        String loadPath = "http://172.20.10.2:8080/gotit/resource/" + session.getUserId() + "/" + articleId + "/" + file.getOriginalFilename();

        return new ResponseEntity<>( new UploadStatus(1, loadPath, file.getOriginalFilename()),HttpStatus.OK);
    }

    @GetMapping("/gotit/resource/{userId}/{articleId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") String filename, @PathVariable("userId") String userId, @PathVariable("articleId") String articleId) {


        Resource file = resourceService.loadAsResource(Paths.get(DATA_SOURCE, userId, articleId, filename));
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
