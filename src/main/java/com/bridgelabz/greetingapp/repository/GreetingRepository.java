package com.bridgelabz.greetingapp.repository;
import com.bridgelabz.greetingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Marks this as a repository (like a DAO)
public interface GreetingRepository extends JpaRepository<Greeting,Long> {
    // No need to write SQL queries! Spring Boot does everything.
}
