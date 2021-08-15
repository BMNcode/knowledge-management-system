//package org.bmn.knowledgemanagementsystem.controller;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.bmn.knowledgemanagementsystem.model.Branch;
//import org.bmn.knowledgemanagementsystem.model.Directory;
//import org.bmn.knowledgemanagementsystem.service.BranchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/")
//@Slf4j
//public class BranchController {
//
//    private final BranchService branchService;
//
//    @Autowired
//    public BranchController(BranchService branchService) {
//        this.branchService = branchService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Branch> createBranch(@Valid @RequestBody Branch branch) {
//        log.info(BranchController.class.getSimpleName() + " ---> create branch : " + branch.toString());
//        return ResponseEntity.ok(branchService.save(branch));
//    }
//
//    @PostMapping("/{branch_name}")
//    public ResponseEntity<Branch> createDirectory(@Valid @RequestBody Directory directory,
//                                                  @PathVariable(value = "branch_name") String branchName,
//                                                  String directoryName) {
//        log.info(BranchController.class.getSimpleName() + " ---> createDirectory : " + directory.toString());
//        return ResponseEntity.ok(branchService.addDirectory(directory, name));
//    }
//}
