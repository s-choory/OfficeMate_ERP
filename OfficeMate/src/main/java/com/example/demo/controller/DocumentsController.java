package com.example.demo.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DocumentsService;
import com.example.demo.service.UserService;



@Controller
public class DocumentsController {
	
	@Autowired
	DocumentsService documentsService;
	@Autowired
	UserService userSerivce;
	
	@GetMapping("/admin/document")
    public String documentAll(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    	PageDTO pageDTO = new PageDTO(documentsService.documentsGetCount(), page);
    	List<DocumentDTO> list = documentsService.getListAdminPage(pageDTO);
    	model.addAttribute("documentList",list);
    	model.addAttribute("page", page);
    	model.addAttribute("pageDTO", pageDTO);
    	return "document/adminDocument";
    }
	
    @GetMapping("/document")
    public String document(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	PageDTO pageDTO = new PageDTO(documentsService.documentsGetCount(), page);
    	List<DocumentDTO> list = documentsService.getListPage(pageDTO, name);
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
    public String documentAddConfirm(DocumentDTO documentDTO, @RequestParam("file") MultipartFile file) {
        // 업로드된 파일들 처리
    	try {
            if (!file.isEmpty()) {
            	byte[] fileBytes = file.getBytes();
            	String fileName = file.getOriginalFilename();
            	
                documentDTO.setFiles(fileBytes);
                documentDTO.setFileName(fileName);
            }
    	} catch (Exception e) {
		}
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 현재 인증된 사용자 이름
        UserDTO userDTO = userSerivce.getUserByName(username);
        documentDTO.setUploadedBy(userDTO.getUserId());
        documentDTO.setUploadUser(userDTO.getUsername());
        
    	int n = documentsService.documentAdd(documentDTO);
    	System.out.println(n);

    	return "redirect:/document";
    }
    
    @GetMapping("/document/{documentId}")
    public String documentContent(@PathVariable Integer documentId, Model model) {
    	DocumentDTO documentDTO = documentsService.documentOne(documentId);
    	
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(!name.equals(documentDTO.getUploadUser()) && !name.equals(documentDTO.getShareUser())) {
    		return "redirect:/document";
    	}
    	
    	model.addAttribute("document", documentDTO);
    	return "document/document_content";
    }
    
    // 파일 다운로드
    @GetMapping("/document/download/{documentId}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Integer documentId) {
        DocumentDTO documentDTO = documentsService.documentOne(documentId);
        byte[] fileBytes = documentDTO.getFiles();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", encodeFilename(documentDTO.getFileName()));
        headers.setContentLength(fileBytes.length);

        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }
    
    @GetMapping("/documentEdit/{documentId}")
    public String documentEdit(@PathVariable Integer documentId, Model model) {
        DocumentDTO documentDTO = documentsService.documentOne(documentId);
        
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(!name.equals(documentDTO.getUploadUser()) && !name.equals(documentDTO.getShareUser())) {
    		return "redirect:/document";
    	}
    	
        model.addAttribute("document", documentDTO);
    	return "document/document_edit";
    }
    
    @PostMapping("/documentEditConfirm")
    public String documentEditConfirm(DocumentDTO documentDTO, @RequestParam("file") MultipartFile file) {
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(!name.equals(documentDTO.getUploadUser()) && !name.equals(documentDTO.getShareUser())) {
    		return "redirect:/document";
    	}
    	try {
            if (!file.isEmpty()) {
            	byte[] fileBytes = file.getBytes();
            	String fileName = file.getOriginalFilename();
                documentDTO.setFiles(fileBytes);
                documentDTO.setFileName(fileName);
                
                int n = documentsService.documentEditFile(documentDTO);
                System.out.println("Correct fileUpdate:"+n);
            }
    	} catch (Exception e) {
		}
    	
    	int n = documentsService.documentEdit(documentDTO);
    	System.out.println(n);
    	
    	return "redirect:/document/"+documentDTO.getDocumentId();
    }
   
    
    @GetMapping("/documentDelete")
    public String documentDelete(@RequestParam Integer documentId) {
    	DocumentDTO documentDTO = documentsService.documentOne(documentId);
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(!name.equals(documentDTO.getUploadUser()) && !name.equals(documentDTO.getShareUser())) {
    		return "redirect:/document";
    	}
    	
    	int n = documentsService.documentDelete(documentId);
    	System.out.println(n);
    	return "redirect:/document";
    }
    
    @GetMapping("/userSearch")
    public String userSearch(@RequestParam String userName, @RequestParam int documentId,Model model) {
    	model.addAttribute("documentId",documentId);
    	if(userName == null || userName.equals("")) {
    		List<UserDTO> userList = userSerivce.getUserByNamIncluded("");
    		model.addAttribute("userList",userList);
    		System.out.println(userList.size());
    	}else {
	    	List<UserDTO> userList = userSerivce.getUserByNamIncluded(userName);
	    	System.out.println(userList.size());
	    	model.addAttribute("userList",userList);
    	}
    	return "document/user_search";
    }
    @GetMapping("/updateDocumentShareUser")
    public String updateDocumentShareUser(@RequestParam String username, @RequestParam int documentId,Model model) {
    	int n = documentsService.updateDocumentShareUser(username, documentId);
    	System.out.println(n);
    	return "redirect:document/"+documentId;
    }

    
    // 파일 이름을 UTF-8로 인코딩하는 메서드
    private String encodeFilename(String filename) {
        // 파일 이름이 null이 아닌 경우 UTF-8로 인코딩하여 반환
        if (filename != null) {
            return new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        }
        return "";
    }
}
