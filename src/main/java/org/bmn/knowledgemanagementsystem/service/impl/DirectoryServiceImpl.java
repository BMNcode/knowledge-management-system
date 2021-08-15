package org.bmn.knowledgemanagementsystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bmn.knowledgemanagementsystem.model.Directory;
import org.bmn.knowledgemanagementsystem.repository.DirectoryRepository;
import org.bmn.knowledgemanagementsystem.service.DirectoryService;
import org.dom4j.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("directoryService")
@Slf4j
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }


    @Override
    public Directory saveBranch(Directory branch) {
        log.info(DirectoryServiceImpl.class.getSimpleName() + " ---> saveBranch: " + branch.toString());
        if (directoryRepository.findByName(branch.getName()) != null) {
            
        }
        return directoryRepository.save(branch);
    }

    @Override
    @Transactional(readOnly = true)
    public Directory findById(Long id) {
        return directoryRepository.findById(id).get();
    }

    @Override
    public Directory findByName(String name) {
        return directoryRepository.findByName(name);
    }

    @Override
    public Directory createSubDirectory(Directory directory, String rootName) {
        directoryRepository.save(directory);
        Directory root = directoryRepository.findByName(rootName);
        List<Directory> directories = new ArrayList<>();
        directories.add(directory);
//        root.getDirectories().add(directory);
        directoryRepository.save(root);
        return root;
    }

    @Override
    public List<Directory> findALl() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
