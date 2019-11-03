package com.example.wcnm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Page {
    private int allCount;
    private int currentPage;
    private int size;
}
