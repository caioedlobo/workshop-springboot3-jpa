package com.projectspring.course.repositories;

import com.projectspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {     //instancia um obejto repository que tem várias ooeprações para trabalhar com o usuário

}
