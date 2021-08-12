package org.bmn.knowledgemanagementsystem.controller;


import org.bmn.knowledgemanagementsystem.model.Directory;
import org.bmn.knowledgemanagementsystem.service.DirectoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class DirectoryController {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("/{directory_name}")
    public ResponseEntity<Directory> getDirectory(@PathVariable(value = "directory_name") String rootName) {
        logger.debug(">>>>>>> show directory ");
        return ResponseEntity.ok(directoryService.findByName(rootName));
    }

    @PostMapping
    public Directory createDirectory(@Valid @RequestBody Directory directory) {
        logger.debug(">>>>>>> create directory ");
        return directoryService.save(directory);
    }

    @PutMapping("/{directory_name}")
    public Directory createSubDirectory(@Valid @RequestBody Directory directory,
                                        @PathVariable(value = "directory_name") String root) {
        logger.debug(">>>>>>> create subdirectory ");
        return directoryService.createSubDirectory(directory, root);
    }
}
