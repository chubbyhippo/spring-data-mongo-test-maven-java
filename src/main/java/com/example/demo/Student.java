package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Student {
   @Id
   private String id;

   private String firstname;
   private String lastname;
}
