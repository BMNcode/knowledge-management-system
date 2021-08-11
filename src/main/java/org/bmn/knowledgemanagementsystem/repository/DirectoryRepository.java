package org.bmn.knowledgemanagementsystem.repository;

import org.bmn.knowledgemanagementsystem.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {
    Directory findByName(String name);
}
