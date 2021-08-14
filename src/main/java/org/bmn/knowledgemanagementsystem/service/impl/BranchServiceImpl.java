package org.bmn.knowledgemanagementsystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bmn.knowledgemanagementsystem.model.Branch;
import org.bmn.knowledgemanagementsystem.model.Directory;
import org.bmn.knowledgemanagementsystem.repository.BranchRepository;
import org.bmn.knowledgemanagementsystem.repository.DirectoryRepository;
import org.bmn.knowledgemanagementsystem.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("BranchService")
@Slf4j
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final DirectoryRepository directoryRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, DirectoryRepository directoryRepository) {
        this.branchRepository = branchRepository;
        this.directoryRepository = directoryRepository;
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch findByName(String name) {
        return branchRepository.findByName(name);
    }

    @Override
    public Branch addDirectory(Directory directory, String branchName) {
        directoryRepository.save(directory);
        log.debug(">>>>>>>>>>>> service - save: " + directory.toString());
        Branch branch = branchRepository.findByName(branchName);
        branch.getDirectories().add(directory);
        branchRepository.save(branch);
        log.debug(">>>>>>>>>>>> service - save: " + branch.toString());
        return branch;
    }
}
