package com.example.demo.model;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.*;
import com.example.demo.model.*;
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@AllArgsConstructor

public class CustomerDTO {

	Customer[] custList;
}
