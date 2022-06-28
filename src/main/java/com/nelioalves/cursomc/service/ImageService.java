//package com.nelioalves.cursomc.service;
//
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.nelioalves.cursomc.service.exceptions.FileException;
//
//@Service
//public class ImageService {
//	
//	public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) {
//		
//		try {
//			
//		String ext = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
//		if(!"png".equals(ext) && !"jpg".equals(ext)) {
//			throw new FileException("Somente imagens PNG e JPG são permitidas");
//		}
//		
//		
//			BufferedImage img = ImageIO.read(uploadedFile.getInputStream());
//			if("png".equals(ext)) {
//				img = pngToJpg(img);
//			}
//		} catch (IOException e) {
//			throw new FileException("Erro ao ler arquivo");
//		}
//	}
//
//	private BufferedImage pngToJpg(BufferedImage img) {
//		BufferedImage
//	}
//}
