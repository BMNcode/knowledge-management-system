package org.bmn.knowledgemanagementsystem.service.impl;

import org.bmn.knowledgemanagementsystem.model.Directory;
import org.bmn.knowledgemanagementsystem.repository.DirectoryRepository;
import org.bmn.knowledgemanagementsystem.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }


    @Override
    public Directory save(Directory directory) {
        return directoryRepository.save(directory);
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
