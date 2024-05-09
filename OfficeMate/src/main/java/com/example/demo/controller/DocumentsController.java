package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.service.DocumentsService;



@Controller
public class DocumentsController {
	
	@Autowired
	DocumentsService documentsService;
	
    @GetMapping("/document")
    public String document(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    	PageDTO pageDTO = new PageDTO(documentsService.documentsGetCount(), page);
    	List<DocumentDTO> list = documentsService.getListPage(pageDTO);
    	System.out.println(list);
    	model.addAttribute("documentList",list);
    	model.addAttribute("page", page);
    	model.addAttribute("pageDTO", pageDTO);
    	return "document/document";
    }
    
    @GetMapping("/documentAdd")
    public String documentAdd() {
    	return "document/document_add";
    }
    
    @PostMapping("/documentAddConfirm")
    public String documentAddConfirm(DocumentDTO documentDTO, @RequestParam("files") MultipartFile[] files) {
        // 업로드된 파일들 처리
    	try {
	        for (MultipartFile file : files) {
	            if (!file.isEmpty()) {
	                byte[] fileBytes = file.getBytes();
	                // DB에 파일 저장하는 로직 구현
//	                documentsService.saveDocumentToDB(documentDTO, fileBytes);
	            } else {
	                // 파일이 비어있는 경우 에러 처리
	            }
	        }
    	} catch (Exception e) {
		}

    	return "redirect:/document";
    }
}
