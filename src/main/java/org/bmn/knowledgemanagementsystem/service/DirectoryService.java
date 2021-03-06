package org.bmn.knowledgemanagementsystem.service;

import org.bmn.knowledgemanagementsystem.model.Directory;

import java.util.List;

public interface DirectoryService {

    Directory save(Directory directory);

    Directory findById(Long id);

    Directory findByName(String name);

    Directory createSubDirectory(Directory directory, String rootName);

    List<Directory> findALl();

    void deleteById(Long id);

}

